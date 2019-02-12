package com.stylefeng.guns.modular.dist.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 参数设置Dao
 *
 * @author huangpu
 * @Date 2018-04-06 11:33:32
 */
public interface DisProfitParamDao {

    List<Map<String, Object>> selectList(@Param("account") String account,@Param("calModel") String calModel
            ,@Param("accountType") String accountType,@Param("disUserType") String disUserType,@Param("disUserRank") String disUserRank);

}
