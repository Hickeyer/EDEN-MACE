package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisDictionaryMapper;
import com.stylefeng.guns.common.persistence.model.DisDictionary;
import com.stylefeng.guns.modular.dist.dao.DisDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisDictionaryService;

import java.util.List;
import java.util.Map;

/**
 * 字典Dao
 *
 * @author fengshuonan
 * @Date 2018-04-06 13:57:03
 */
@Service
public class DisDictionaryServiceImpl implements IDisDictionaryService {


    @Autowired
    DisDictionaryDao disDictionaryDao;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public  List<Map<String, Object>> selectListByCode(String code) {
        List<Map<String, Object>> list=disDictionaryDao.selectListByCode(code);
        return list;
    }
}
