package com.rule.graph.mybatis.dao;

import com.rule.graph.mybatis.domain.DisProfitParam;

public interface DisProfitParamMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(DisProfitParam record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(DisProfitParam record);

    /**
     *
     * @mbg.generated
     */
    DisProfitParam selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DisProfitParam record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DisProfitParam record);
}