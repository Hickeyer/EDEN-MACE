package com.stylefeng.guns.modular.dist.dao;

import com.stylefeng.guns.common.persistence.model.DisDictionary;

import java.util.List;
import java.util.Map;

/**
 * 字典Dao
 *
 * @author fengshuonan
 * @Date 2018-04-06 13:57:03
 */
public interface DisDictionaryDao {

    public  List<Map<String, Object>> selectListByCode(String code);

}
