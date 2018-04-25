package com.stylefeng.guns.modular.system.dao;

import java.util.List;
import java.util.Map;

/**
 * sysDicDao
 *
 * @author fengshuonan
 * @Date 2018-02-24 11:05:57
 */
public interface SysDicDao {

    public List<Map<String, Object>> selectListByCode(String code);
}
