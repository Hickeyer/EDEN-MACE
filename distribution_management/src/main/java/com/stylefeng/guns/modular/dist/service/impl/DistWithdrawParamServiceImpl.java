package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DistWithdrawParamMapper;
import com.stylefeng.guns.common.persistence.model.DisWithdrawRecord;
import com.stylefeng.guns.common.persistence.model.DistWithdrawParam;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.modular.dist.dao.DistWithdrawParamDao;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDistWithdrawParamService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提现参数设置Dao
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:54:36
 */
@Service
@Transactional
public class DistWithdrawParamServiceImpl implements IDistWithdrawParamService {

    @Resource
    DistWithdrawParamDao distWithdrawParamDao;

    @Resource
    DistWithdrawParamMapper distWithdrawParamMapper;

    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList() {
        List<Map<String, Object>> list=distWithdrawParamDao.selectList();
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(DistWithdrawParam param) {
        Integer count=distWithdrawParamDao.count(param.getBeginAmount(),param.getEndAmount());
        if(count>0){
            throw  new BussinessException(BizExceptionEnum.DATA_EXITS);
        }
        param.setAddTime(DateUtils.getNowDateTime());
        distWithdrawParamMapper.insert(param);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void delete(Integer id) {
        distWithdrawParamMapper.deleteById(id);
    }

    @Override
    public Map<String, Object> calAmount(BigDecimal amount) {
        Map<String,Object> map=new HashMap<>();
        DistWithdrawParam param=distWithdrawParamDao.selectOneParam(amount);
        if(param==null){
            map.put("realAmount",amount);
            map.put("feeAmount",new BigDecimal(0));
        }else{
            map.put("realAmount",amount.subtract(new BigDecimal(param.getDisWithdrawValue())));
            map.put("feeAmount",new BigDecimal(param.getDisWithdrawValue()));
        }
        return map;
    }

}
