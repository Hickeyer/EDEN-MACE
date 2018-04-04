package com.distribution.service.impl;

import com.distribution.common.mapper.DisProfiParamMapper;
import com.distribution.common.model.DisProfiParam;
import com.distribution.common.util.DateUtils;
import com.distribution.common.util.Page;
import com.distribution.service.DisProfiParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangpu on 2017/6/6.
 */
@Service
public class DisProfiParamServiceImpl implements DisProfiParamService {

    @Autowired
    DisProfiParamMapper disProfiParamMapper;

    public  void  save(DisProfiParam param){
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        param.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        param.setIsDelete("N");
        disProfiParamMapper.insert(param);
    }

    public List<DisProfiParam> selectList(DisProfiParam param) {
        if(param.getPageNo()!=null&&param.getPageSize()!=null){
            Integer pageStart= Page.getStartOfPage(param.getPageNo(),param.getPageSize());
            param.setPageStart(pageStart);
        }

        List<DisProfiParam> profiParamList=disProfiParamMapper.selectList(param);
        return profiParamList;
    }
}
