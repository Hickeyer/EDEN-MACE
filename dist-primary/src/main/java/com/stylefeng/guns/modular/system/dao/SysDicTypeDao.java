package com.stylefeng.guns.modular.system.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.common.persistence.model.OperationLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * sysDicTypeDao
 *
 * @author huangpu
 * @Date 2018-02-24 11:06:31
 */
public interface SysDicTypeDao {


    /**
     * 查询字典类型  列表
     * @param dicTypeName
     * @return
     */
    List<Map<String, Object>> list(@Param("dicTypeName") String dicTypeName);

    List<Map<String, Object>> getDicList(@Param("page") Page<OperationLog> page, @Param("condition") String condition);

}
