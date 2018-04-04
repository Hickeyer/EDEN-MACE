package com.distribution.service;

import com.distribution.common.model.DisProfiParam;

import java.util.List;

/**
 * Created by huangpu on 2017/6/6.
 */
public interface DisProfiParamService {

    public  void  save(DisProfiParam param);

    public List<DisProfiParam> selectList(DisProfiParam param);

}
