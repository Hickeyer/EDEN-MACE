package com.stylefeng.guns.modular.dist.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 交易Dao
 *
 * @author huangpu
 * @Date 2018-04-06 12:19:23
 */
public interface DisProfitRecordDao {

    List<Map<String, Object>> selectList(@Param("account")  String account);
}
