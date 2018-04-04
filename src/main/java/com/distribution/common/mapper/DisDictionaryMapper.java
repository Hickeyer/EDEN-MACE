package com.distribution.common.mapper;

import com.distribution.common.model.DisDictionary;

import java.util.List;

public interface DisDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisDictionary record);

    int insertSelective(DisDictionary record);

    DisDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisDictionary record);

    int updateByPrimaryKey(DisDictionary record);

    List<DisDictionary> selectListByCode(String code);
}