package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisMemberAmountMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisMemberAmountDao;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 账户管理Dao
 *
 * @author xiaojiang
 * @Date 2018-05-08 21:16:47
 */
@Service
public class DisMemberAmountServiceImpl implements IDisMemberAmountService {

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    DisMemberAmountMapper disMemberAmountMapper;

    @Resource
    DisMemberAmountDao disMemberAmountDao;


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(String userId, String userName, String type) {
        Wrapper<DisMemberAmount> memberAmountWrapper=new EntityWrapper();
        memberAmountWrapper.eq("dis_user_id",userId);
        Integer count= disMemberAmountMapper.selectCount(memberAmountWrapper);
        if(count==0){
            DisMemberAmount amount=initAmount(userId,userName,type);
            disMemberAmountMapper.insert(amount);
        }
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String platformId) {
        List<Map<String, Object>> list= disMemberAmountDao.selectList(platformId);
        return list;
    }

    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public DisMemberAmount initAmount(String userId, String userName, String type){
        DisMemberAmount amount=new DisMemberAmount();
        amount.setDisUserId(userId);
        amount.setDisUserName(userName);
        amount.setType(type);
        amount.setAmountStatus("0");
        amount.setAvaibleAmount(new BigDecimal(0));
        amount.setFrozenAmount(new BigDecimal(0));
        amount.setTotalAmount(new BigDecimal(0));
        amount.setLevelAvaibleAmount(new BigDecimal(0));
        amount.setLevelFrozenAmount(new BigDecimal(0));
        amount.setLevelTotalAmount(new BigDecimal(0));
        amount.setTradeAvaibleAmount(new BigDecimal(0));
        amount.setTradeFrozenAmount(new BigDecimal(0));
        amount.setTradeTotalAmount(new BigDecimal(0));
        amount.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        amount.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        return amount;
    }
}
