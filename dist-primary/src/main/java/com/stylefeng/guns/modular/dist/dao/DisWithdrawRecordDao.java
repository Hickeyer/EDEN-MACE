package com.stylefeng.guns.modular.dist.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 提现记录Dao
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:08
 */
public interface DisWithdrawRecordDao {

    List<Map<String, Object>> selectList(@Param("account") String account,@Param("disUserId") String disUserId,
                                         @Param("withdrawNum") String withdrawNum,@Param("withdrawStatus") String withdrawStatus
                                         ,@Param("accountType") String accountType);

}
