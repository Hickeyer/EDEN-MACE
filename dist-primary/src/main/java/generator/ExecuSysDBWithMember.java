package generator;

import com.stylefeng.guns.common.persistence.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName ExecuSysDBWithMember
 * @autor hickey
 * @DATE 2020/3/23
 *
 * 执行同步会员数据
 *
 **/
public class ExecuSysDBWithMember {

    private JdbcTemplate jdbcTemplate;

    private int updateBatchSzie = 3000;

    long pageSize = 10000L;
    ThreadPoolExecutor executor = new ThreadPoolExecutor(0,20,
            60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(20));

    public ExecuSysDBWithMember() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/plugin/syn_db_set.xml.xml");
        jdbcTemplate= (JdbcTemplate)ctx.getBean("jdbcTemplate");

        //  设置策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public void process() throws  Exception{
        String path = this.getClass().getResource("/plugin/member_relation.properties").getPath();
        FileInputStream in = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(in);
        String old_db = properties.get("db1_name").toString();
        String old_table = properties.get("old_table").toString();
        String oder_key = properties.get("oder_key").toString();
        String dis_platform_id = properties.get("dis_platform_id").toString();
        String sql  ="select * from "+old_db+"."+old_table
                +" where "+oder_key+" > ?"
                +" order by "+ oder_key
                +" limit ?";
        int size =0;
        List<Future<Boolean>> resultList =  new ArrayList<Future<Boolean>>();
        Map<String,Object> userMap = findPlatInfo(dis_platform_id);
        if(null == userMap){
            System.out.println("配置代理错误,请检查...");
            return ;
        }
        System.out.println("sql>> "+sql);
        // 这个类型可为字符串 可为整型，要看具体的排序字段
        String startId = "";
        do {
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,startId,pageSize);
            if(CollectionUtils.isEmpty(list)){
                break;
            }
            size = list.size();
            startId = (String) list.get(list.size()-1).get(oder_key);
            Callable<Boolean>  task = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    initDBToFenxiao(list,properties,userMap);
                    return true;
                }
            };

            Future<Boolean> future = executor.submit(task);
            resultList.add(future);


        }while (size == pageSize);
        for (Future<Boolean> future:resultList){
            future.get();
        }

        System.out.println("所有数据处理完成");
    }


    public Map<String,Object> findPlatInfo(String account){
        String sql = "SELECT * FROM authority.user   WHERE account=? ";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,account);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        User user = new User();
        Map<String,Object> map = list.get(0);
        return map;
    }
    private void initDBToFenxiao(List<Map<String, Object>> list
            ,Properties properties, Map<String,Object> userMap) {
        String member_key = properties.get("member_key").toString();
        String member_name = properties.get("member_name").toString();
        String dis_platform_id = properties.get("dis_platform_id").toString();
        Integer disPlatLevel = Integer.valueOf(userMap.get("level").toString());
        String fullIndex = userMap.get("fullindex").toString();
        String platSuper =  userMap.get("account").toString();
        List<Object[]> memberList = new ArrayList<>();
        List<Object[]> memberAmountList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        list.forEach((map)->{
            String key = (String) map.get(member_key);
            String name = (String) map.get(member_name);
            Object[] member = new Object[]{
                    dis_platform_id,
                    key,
                    key,
                    name,
                    now,
                    now,
                    platSuper,
                    fullIndex,
                    disPlatLevel

            };
            Object[] amount = new Object[]{
                    key,
                    name,
                    now,
                    now
            };
            memberList.add(member);
            memberAmountList.add(amount);
            if(memberList.size()>updateBatchSzie){
                insertMemberInfo(memberList);
            }
            if(memberAmountList.size()>updateBatchSzie){
                insertMemberAmount(memberAmountList);
            }
        });
        if(memberList.size()>0){
            insertMemberInfo(memberList);
        }
        if(memberAmountList.size()>0){
            insertMemberAmount(memberAmountList);
        }
    }

    public static void main(String[] args) throws Exception {
        long start  = System.currentTimeMillis();
        new ExecuSysDBWithMember().process();

        long end  = System.currentTimeMillis();

        System.out.println("耗时:"+(end-start)/1000+"秒");
    }


    public void insertMemberInfo(List<Object[]> params){
        System.out.println("开始插入会员表:"+params.size());
        int  []  result=  jdbcTemplate.batchUpdate(insertMemberInfoSql,params);
        params.clear();
        System.out.println("插入会员表成功");
    }
    public void insertMemberAmount(List<Object[]> params){
        System.out.println("开始插入金额表:"+params.size());
        jdbcTemplate.batchUpdate(insertMemberAmountSql,params);
        params.clear();
        System.out.println("插入金额表成功");
    }
    private  String  insertMemberInfoSql =
            " INSERT INTO `distribution`.`dis_member_info`"
            +"            (                          "
            +"             `dis_platform_id`,             "
            +"             `dis_user_id`,                 "
            +"             `dis_model_id`,                "
            +"             `dis_full_index`,              "
            +"             `dis_user_name`,               "
            +"             `dis_level`,                   "
            +"             `dis_user_type`,               "
            +"             `dis_note`,                    "
            +"             `add_time`,                    "
            +"             `update_time`,                 "
            +"             `dis_plat_super`,              "
            +"             `dis_plat_full_index`,         "
            +"             `dis_plat_level`)              "
            +" VALUES (                              "
            +"        ?,                  " // 平台
            +"        ?,                      "  // 用户id
            +"        null,                     " // 上级id
            +"        ?,                   " //全路径
            +"        ?,                    " //用户姓名
            +"        '0',                        "// 级别
            +"        '0',                    "
            +"        '第三方数据导入',                         "
            +"        ?,                         "//添加时间
            +"        ?,                      "//更新时间
            +"        ?,                   "//上级代理商id
            +"        ?,              "//代理商全路径
            +"        ?);                    ";//代理商等级

    private  String insertMemberAmountSql =
                    " INSERT INTO `distribution`.`dis_member_amount`"
                    +"            (                         "
                    +"             `dis_user_id`,                   "
                    +"             `dis_user_name`,                 "
                    +"             `total_amount`,                  "
                    +"             `frozen_amount`,                 "
                    +"             `avaible_amount`,                "
                    +"             `type`,                          "
                    +"             `add_time`,                      "
                    +"             `update_time`,                   "
                    +"             `amount_status`,                 "
                    +"             `trade_total_amount`,            "
                    +"             `trade_frozen_amount`,           "
                    +"             `trade_avaible_amount`,          "
                    +"             `level_total_amount`,            "
                    +"             `level_frozen_amount`,           "
                    +"             `level_avaible_amount`,          "
                    +"             `invite_total_amount`,           "
                    +"             `invite_frozen_amount`,          "
                    +"             `invite_avaible_amount`)         "
                    +" VALUES (                            "
                    +"        ?,                        " // 会员id
                    +"        ?,                      "  //会员名称
                    +"        0,                       "
                    +"        0,                      "
                    +"        0,                     "
                    +"        0,                               "
                    +"        ?,                           "//添加时间
                    +"        ?,                        "// 更新时间
                    +"        0,                      "
                    +"        0,                 "
                    +"        0,                "
                    +"        0,               "
                    +"        0,                 "
                    +"        0,                "
                    +"        0,               "
                    +"        0,                "
                    +"        0,               "
                    +"        0);             ";


}

    
    