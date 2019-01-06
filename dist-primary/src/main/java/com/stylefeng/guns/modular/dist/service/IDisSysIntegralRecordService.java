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


    /**
     *
     * @param accountType 事件类型
     * @param amount
     * @param memberInfo
     */
    public void saveIntegral(String accountType, BigDecimal amount, DisMemberInfo memberInfo) throws Exception;

}
