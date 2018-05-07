package com.stylefeng.guns.modular.dist.service.impl;

import com.google.gson.Gson;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountMongoService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.TradeAmountVo;
import com.stylefeng.guns.modular.system.dao.SysDicDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DisMemberAmountServiceMongoImpl implements IDisMemberAmountMongoService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    SysDicDao sysDicDao;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(String userId,String userName,String disPlatformId,String type) {
        Query query=new Query();
        Criteria criteria1=Criteria.where("disUserId").is(userId);
        Criteria criteria2=Criteria.where("disPlatformId").is(disPlatformId);
        query.addCriteria(criteria1);
        query.addCriteria(criteria2);
        long count= mongoTemplate.count(query, "amount");
        if(count==0){
            Map<String,String> amount=initAmount(userId,userName,disPlatformId,"0");
            mongoTemplate.save(amount,"amount");
        }

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

    @Override
    public List<Map<String, Object>> selectList() {
        Query query=new Query();
        if(!ShiroKit.hasRole(Const.ADMIN_NAME)){
            String account= ShiroKit.getUser().getAccount();
            Criteria criteria=Criteria.where("disPlatformId").is(account);
            query.addCriteria(criteria);
        }
        List<Object> vo=mongoTemplate.find(query,Object.class,"amount");
        List<Map<String, Object>> result=new ArrayList<>();
        if(vo.size()>0){
            vo.forEach(info->{
                Map<String,Object> map= (Map<String, Object>) info;
                result.add(map);
            });
        }
        return result;
    }

    @Override
    public void tradeAmount(TradeAmountVo tradeAmountVo) {
        if("1".equals(tradeAmountVo.getType())){
        Query query=new Query();
        Criteria disPlatformId=Criteria.where("disPlatformId").is(tradeAmountVo.getDisPlatformId());
        Criteria disUserId= Criteria.where("disUserId").is(tradeAmountVo.getUserId());
        Criteria type= Criteria.where("type").is(tradeAmountVo.getType());

        query.addCriteria(disPlatformId);
        query.addCriteria(disUserId);
        query.addCriteria(type);
        Object vo=mongoTemplate.find(query,Object.class,"amount");
        }else if("0".equals(tradeAmountVo.getType())){

        }
    }


    /**
     * 初始化账户信息
     * @param userId
     * @param userName
     * @return
     */
    public Map<String,String> initAmount(String userId,String userName,String disPlatformId,String type){
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
        map.put("type",type);

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
