package com.distribution.service.impl;

import com.distribution.common.mapper.DisDictionaryMapper;
import com.distribution.common.model.DisDictionary;
import com.distribution.service.DisDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangpu on 2017/6/6.
 */
@Service
public class DisDictionaryServiceImpl implements DisDictionaryService {

    @Autowired
    DisDictionaryMapper disDictionaryMapper;

    @Override
    public List<DisDictionary> selectListByCode(String code) {
        List<DisDictionary> list=disDictionaryMapper.selectListByCode(code);
        return list;
    }
}
