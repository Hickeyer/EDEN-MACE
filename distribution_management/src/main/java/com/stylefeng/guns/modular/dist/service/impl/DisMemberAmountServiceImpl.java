package com.stylefeng.guns.modular.dist.service.impl;

import com.google.gson.Gson;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.system.dao.SysDicDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DisMemberAmountServiceImpl implements IDisMemberAmountService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    SysDicDao sysDicDao;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(String param) {
        Map<String,String> amount=initAmount("11","sss","admin");
        mongoTemplate.save(amount,"amount");
    }

    @Override
    public List<Object> list(String param) {
        Query query=new Query();
        if(StringUtils.isNotEmpty(param)){
            Gson gson=new Gson();
            Map<String,String> map=gson.fromJson(param, Map.class);
            for (Map.Entry<String, String> entry: map.entrySet()){
                Criteria criteria=Criteria.where(entry.getKey()).is(entry.getValue());
                query.addCriteria(criteria);
            }
        }
        if(!ShiroKit.hasRole(Const.ADMIN_NAME)){
            String account= ShiroKit.getUser().getAccount();
            Criteria criteria=Criteria.where("disPlatformId").is(account);
            query.addCriteria(criteria);
        }
        List<Object> vo=mongoTemplate.find(query,Object.class,"amount");
        return vo;
    }


    /**
     * 初始化账户信息
     * @param userId
     * @param userName
     * @return
     */
    public Map<String,String> initAmount(String userId,String userName,String disPlatformId){
        Map<String,String> map=new HashMap<>();
        map.put("disUserId",userId);
        map.put("disUserName",userName);
        map.put("disPlatformId",disPlatformId);
        map.put("totalAmount","0.00");
        map.put("frozenAmount","0.00");
        map.put("avaibleAmount","0.00");
        map.put("addTime", DateUtils.getNowDateTime());
        map.put("updateTime",DateUtils.getNowDateTime());
        map.put("amountStatus","0");

        List<Map<String, Object>> list=  sysDicDao.selectListByCode("disProType");
        if(list.size()>0){
            list.forEach(single->{
               single.forEach((k,v)->{
                   if("dicNotes".equals(k)){
                       map.put((String) v,"0.00");
                   }
               });
            });
        }
        return map;
    }
}
