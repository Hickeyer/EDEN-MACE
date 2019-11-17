package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.AmoutLock;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.*;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.modular.dist.amountTemplate.AmountTemplateFactoryContext;
import com.stylefeng.guns.modular.dist.amountsign.AmountFactoryContext;
import com.stylefeng.guns.modular.dist.dao.DisProfitRecordDao;
import com.stylefeng.guns.modular.dist.service.*;
import com.stylefeng.guns.modular.dist.task.AgentRankTask;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.util.DistUtils;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 交易Dao
 *
 * @author huangpu
 * @Date 2018-04-06 12:19:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DisProfitRecordServiceImpl implements IDisProfitRecordService {

    private Logger logger =  LoggerFactory.getLogger(DisProfitRecordServiceImpl.class);

    @Resource
    DisProfitRecordDao disProfitRecordDao;

    @Resource
    DisProfitParamMapper disProfiParamMapper;

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    DisProfitRecordMapper disProfitRecordMapper;

    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @Autowired
    ISysDicService sysDicService;

    @Autowired
    IDisSysIntegralRecordService disSysIntegralRecordService;

    @Resource
    DisTradeRecordMapper disTradeRecordMapper;

    @Resource
    DisUpgradeRecordMapper disUpgradeRecordMapper;

    @Autowired
    IAmountMangeService amountMangeService;

    @Value("${dist.profit.isUse}")
    private  boolean  isUse;

    @Value("${dist.profit.userModel}")
    private String userModel;

    @Value("${dist.profit.fix}")
    private BigDecimal fix;

    @Value("${dist.profit.rate}")
    private BigDecimal rate;

    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String account,String disGetUserId,String disSetUserId,String disOrderId,String accountType,String userType) {
        List<Map<String, Object>> list=disProfitRecordDao.selectList(account,disGetUserId,disSetUserId,disOrderId,accountType,userType);
        return list;
    }

    /**
     *  根据分润形式设置获取分润
     *  1、根据平台获取设置所有分润列表
     *  2、根据平台和id获取发起交易人员信息
     *  3、根据发起交易人员信息获取上级人员信息
     *  4、根据分润列表和上级人员信息进行匹配，进行分润
     *  5、计算平台分润
     *  6、计算积分
     *  7、记录交易金额/升级信息
     * @param param
     */
    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public void save(DisProfitRecordVo param) throws Exception {
        //根据所属上级和用户id查询会员信息
        DisMemberInfo memberInfoParam=new DisMemberInfo();
        memberInfoParam.setDisUserId(param.getDisSetUserId());
        DisMemberInfo memberInfo=disMemberInfoMapper.selectOne(memberInfoParam);
        generatorAllRecord(param,memberInfo);
        disSysIntegralRecordService.saveIntegral(param.getAccountType(),param.getDisAmount(),memberInfo);
        if(AccountTypeStatus.ZERO_STATUS.getStatus().equals(param.getAccountType())){
            //记录交易金额
            saveTradeRecord(param);
        }else if(AccountTypeStatus.ONE_STATUS.getStatus().equals(param.getAccountType())){
            //记录升级接口
            saveVerticalLevel(memberInfo.getDisUserType(),param.getUpgradeLevel(),param.getDisSetUserId());
        }
    }

    /**
     * 生成所有的分润信息
     * 原则:不能超过交易产生的金额
     * 分别对admin-平台-会员进行分润
     * 如果分润值没有了  则返回
     * @param param
     * @param memberInfo
     */
    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public void generatorAllRecord(DisProfitRecordVo param,DisMemberInfo memberInfo){
        if(param.getDisAmount()!=null&&param.getDisAmount().compareTo(BigDecimal.ZERO)==1){
           packBaseAmount(param);
        }

        calPlatMoney(param,memberInfo);
        calMemberMoney(param,memberInfo);
    }

    private void packBaseAmount(DisProfitRecordVo param){
        BigDecimal baseAmount = BigDecimal.ZERO;
        if(isUse){
            if("fix".equals(userModel)){
                baseAmount = fix;
            }else{
                //如果不是固定金额  则就是按照费率计算
                baseAmount = param.getDisAmount().multiply(rate);
            }
        }else{
            baseAmount = param.getDisAmount();
        }
        //设置基础金额
        param.setBaseAmount(baseAmount);
        param.setBaseFixAmount(baseAmount);
    }

    public  void saveVerticalLevel(String beforeLevel,String afterLevel,String userId){
        DisUpgradeRecord upgradeRecord=new DisUpgradeRecord();
        upgradeRecord.setBeforeUpgradeLevel(beforeLevel);
        upgradeRecord.setAfterUpgradeLevel(afterLevel);
        upgradeRecord.setUpgradeTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        upgradeRecord.setDisUserId(userId);
        int differ=UserTypeStatus.getMethod(afterLevel).getOrder()-
                UserTypeStatus.getMethod(beforeLevel).getOrder();
        upgradeRecord.setLevelDiffer(String.valueOf(differ));
        disUpgradeRecordMapper.insert(upgradeRecord);
    }
    public  void saveTradeRecord(DisProfitRecordVo param){
        DisTradeRecord tradeRecord=new DisTradeRecord();
        tradeRecord.setDisUserId(param.getDisSetUserId());
        tradeRecord.setTradeAmount(param.getDisAmount());
        tradeRecord.setTradeNum(param.getOrderId());
        tradeRecord.setTradeTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disTradeRecordMapper.insert(tradeRecord);
    }



    public void calMemberMoney(DisProfitRecordVo param,DisMemberInfo memberInfo){
        logger.info("用户分润->开始新增用户分润");
        String[] levelInfo=memberInfo.getDisFullIndex().split("\\.");
        logger.info("用户分润->处理上级人员分润{}",levelInfo.length);
        //反转数组
        levelInfo = DistUtils.reverseArray(levelInfo);
        for (int i = 0;i<levelInfo.length;i++){
            String userId  =levelInfo[i];
            logger.info("用户分润->开始处理{}级用户,用户id{}",i,userId);
            if(i==0){
                logger.info("用户分润->自己不能给自己分润,分润用户{},{}",userId,memberInfo.getDisUserId());
                continue;
            }
            addAmountRecord(userId,String.valueOf(i),IdentityStatus.USER_STATUS.getStatus(),param,memberInfo);
        }
        logger.info("用户分润->结束新增用户分润");
    }

    public void calPlatMoney(DisProfitRecordVo param,DisMemberInfo memberInfo){
        logger.info("平台分润->开始新增用户分润");
        String[] levelInfo=memberInfo.getDisPlatFullIndex().split("\\.");
        logger.info("平台分润->处理上级人员分润{}",levelInfo.length);


        for (int i = 0;i<levelInfo.length;i++){
            String userId  =levelInfo[i];
            logger.info("平台分润->开始处理{}级用户,用户id{}",i,userId);
            addAmountRecord(userId,String.valueOf(i),IdentityStatus.PLAT_STATUS.getStatus(),param,memberInfo);
        }
        logger.info("平台分润->结束新增用户分润");
    }

    public void addAmountRecord(String userId,String level,String idType,DisProfitRecordVo param,DisMemberInfo memberInfo){
        DisMemberInfo subMemberParam=new DisMemberInfo();
        subMemberParam.setDisUserId(userId);
        DisMemberInfo subMember=disMemberInfoMapper.selectOne(subMemberParam);

        DisProfitParam disProfitParam = new DisProfitParam();
        //平台
        disProfitParam.setDisPlatformId(subMember.getDisPlatformId());
        //账户类型
        disProfitParam.setAccountType(param.getAccountType());
        //垂直等级 ,admin用户不参与垂直等级 划分
        //admin平台不需要配置段位，没有等级之分
        //因为admin没有业绩的考察，不需要垂直等级,
        //admin网上也没有等级，这个地方则不用设置
        //只要是admin，通过其账户类型有且只有一个分润设置
        if(!userId.equals(SystemUser.ADMIN_INFO.getInfo())){
            disProfitParam.setDisUserRank(subMember.getDisUserRank());
            disProfitParam.setDisProLevel(level);
        }

        //用户类型
        disProfitParam.setDisUserType(subMember.getDisUserType());
        DisProfitParam disProfit = disProfiParamMapper.selectOne(disProfitParam);
        if(disProfit==null){return;}

        BigDecimal value=new BigDecimal(disProfit.getDisProValue());
        BigDecimal newAmount=new BigDecimal(0);
        //根据 计算方式计算 分润
        newAmount = CalModelStatus.getMethod(disProfit.getCalModel()).calResult(param.getBaseFixAmount(),value);

        if(param.getDisAmount()!=null&&param.getDisAmount().compareTo(BigDecimal.ZERO)==1){
            BigDecimal newBaseAmount = param.getBaseAmount().subtract(newAmount);
            if(newBaseAmount.compareTo(BigDecimal.ZERO)==-1){
                return ;
            }else {
                param.setBaseAmount(newBaseAmount);
            }
        }



        //先设置会员分润
        DisProfitRecord record=new DisProfitRecord();
        record.setDisPlatformId(memberInfo.getDisPlatformId());
        record.setDisUserType(disProfit.getDisUserType());
        record.setDisSetUserId(memberInfo.getDisUserId());
        record.setDisNote(param.getNote());
        record.setDisOrderId(param.getOrderId());
        record.setAccountType(param.getAccountType());

        record.setDisAmount(newAmount);
        record.setDisGetUserId(userId);
        record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        record.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        record.setIsDelete("N");
        record.setType(idType);
        record.setProfitNum(sysDicService.getOrderNo("profit"));
        disProfitRecordMapper.insert(record);
        amountMangeService.addMoney(userId,newAmount,memberInfo.getDisUserId(), idType,disProfit.getAccountType());
        //增加会员金额信息
       // AmountTemplateFactoryContext context = new AmountTemplateFactoryContext(disProfit.getAccountType());
        //context.amountTemplate.addMoney(userId,newAmount,memberInfo.getDisUserId(), idType);
    }



    public static void main(String[] args) {
        String promode="0";
        BigDecimal a=new BigDecimal(100);
        BigDecimal b = new BigDecimal(1);
        System.out.println(CalModelStatus.getMethod(promode).calResult(a,b));
    }
}
