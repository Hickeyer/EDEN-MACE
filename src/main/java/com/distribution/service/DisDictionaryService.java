package com.distribution.service;

import com.distribution.common.model.DisDictionary;

import java.util.List;

/**
 * Created by huangpu on 2017/6/6.
 */
public interface DisDictionaryService {

    public List<DisDictionary> selectListByCode(String code);

}
