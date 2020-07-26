package com.rule.graph.mybatis.dao.ext;

import com.rule.graph.mybatis.domain.DisProfitParam;

import java.util.List;

public interface DisProfitParamExtMapper {


    public void insertBatch(List<DisProfitParam> disProfitParams);

}