package com.stylefeng.guns.modular.dist.dao;

import java.util.List;
import java.util.Map;

/**
 * 分销Dao
 *
 * @author fengshuonan
 * @Date 2018-04-05 21:49:44
 */
public interface DisMemberInfoDao {

    List<Map<String, Object>> selectList(String account);
}
