package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;

import java.math.BigDecimal;

/**
 * 系统积分记录Service
 *
 * @author xiaojiang
 * @Date 2018-07-22 01:43:55
 */
public interface IDisSysIntegralRecordService {


    public void saveMember(String disProType, BigDecimal amount, DisMemberInfo memberInfo);

}
