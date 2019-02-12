package com.stylefeng.guns.modular.dist.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 垂直升级配置Dao
 *
 * @author xiaojiang
 * @Date 2018-07-23 16:07:11
 */
public interface DisUpgradeParamDao {

    List<Map<String, Object>> selectList(@Param("upgradeName") String upgradeName);
    List<Map<String, Object>> selectAgentList(@Param("upgradeName") String upgradeName);
}
