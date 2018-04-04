package com.distribution.common.mapper;

import com.distribution.common.model.DisProfiParam;

import java.util.List;

public interface DisProfiParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisProfiParam record);

    int insertSelective(DisProfiParam record);

    DisProfiParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisProfiParam record);

    int updateByPrimaryKey(DisProfiParam record);

    List<DisProfiParam> selectList(DisProfiParam record);
    List<DisProfiParam> selectValueList(DisProfiParam record);
}