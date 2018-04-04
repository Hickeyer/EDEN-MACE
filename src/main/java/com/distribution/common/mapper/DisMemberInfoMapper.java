package com.distribution.common.mapper;

import com.distribution.common.model.DisMemberInfo;

import java.util.List;

public interface DisMemberInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisMemberInfo record);

    int insertSelective(DisMemberInfo record);

    DisMemberInfo select(DisMemberInfo record);

    List<DisMemberInfo> selectList(DisMemberInfo record);

    List<DisMemberInfo> selectValueList(DisMemberInfo record);

    DisMemberInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisMemberInfo record);

    int updateByPrimaryKey(DisMemberInfo record);

    int count(DisMemberInfo record);
}