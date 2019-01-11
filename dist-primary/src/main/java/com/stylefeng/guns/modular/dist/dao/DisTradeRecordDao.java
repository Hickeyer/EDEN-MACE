package com.stylefeng.guns.modular.dist.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.common.persistence.model.DisTradeRecord;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author huangpu
 * @since 2018-07-22
 */
public interface DisTradeRecordDao  {

    /**
     * 计算金额
     * @param startTime
     * @param endTime
     * @return
     */
    BigDecimal findSumAmount(@Param("startTime") String startTime, @Param("endTime") String endTime);

}