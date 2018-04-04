package com.distribution.common.mapper;

import com.distribution.common.model.DisProfitRecord;

import java.util.List;

public interface DisProfitRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DisProfitRecord record);

    int insertSelective(DisProfitRecord record);

    DisProfitRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DisProfitRecord record);

    int updateByPrimaryKey(DisProfitRecord record);

    List<DisProfitRecord> selectList(DisProfitRecord record);
}