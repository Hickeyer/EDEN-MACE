package com.stylefeng.guns.modular.dist.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 账户管理Dao
 *
 * @author xiaojiang
 * @Date 2018-05-08 21:16:47
 */
public interface DisMemberAmountDao {


    List<Map<String, Object>> selectList(@Param("platformId")  String platformId,@Param("disUserId") String disUserId,@Param("userType") String userType);

}
