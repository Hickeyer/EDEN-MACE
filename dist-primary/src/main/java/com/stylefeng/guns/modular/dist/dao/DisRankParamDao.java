package com.stylefeng.guns.modular.dist.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 段位积分Dao
 *
 * @author xiaojiang
 * @Date 2018-07-19 22:08:00
 */
public interface DisRankParamDao {

    List<Map<String, Object>> selectList(@Param("account") String account,@Param("calModel") String calModel
            ,@Param("accountType") String accountType,@Param("disUserType") String disUserType,@Param("disUserRank") String disUserRank);

}
