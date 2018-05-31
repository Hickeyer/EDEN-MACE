package com.stylefeng.guns.modular.dist.dao;

import com.stylefeng.guns.common.persistence.model.DistWithdrawParam;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 提现参数设置Dao
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:54:36
 */
public interface DistWithdrawParamDao {


    List<Map<String, Object>> selectList();

    Integer count(@Param("beginAmount") BigDecimal beginAmount,@Param("endAmount") BigDecimal endAmount);

    DistWithdrawParam selectOneParam(@Param("amount") BigDecimal amount);
}
