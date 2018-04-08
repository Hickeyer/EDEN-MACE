package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisDictionary;

import java.util.List;
import java.util.Map;

/**
 * 字典Service
 *
 * @author fengshuonan
 * @Date 2018-04-06 13:57:03
 */
public interface IDisDictionaryService {
    public  List<Map<String, Object>>selectListByCode(String code);
}
