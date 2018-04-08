package com.stylefeng.guns.modular.dist.dao;

import java.util.List;
import java.util.Map;

/**
 * 参数设置Dao
 *
 * @author fengshuonan
 * @Date 2018-04-06 11:33:32
 */
public interface DisProfiParamDao {

    List<Map<String, Object>> selectList(String account);

}
