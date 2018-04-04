package com.distribution.service;

import com.distribution.common.model.DisMemberInfo;

import java.util.List;

/**
 * Created by huangpu on 2017/6/3.
 */
public interface DisMemberInfoService {

    public void save(DisMemberInfo param) ;

    public List<DisMemberInfo> getMemberList(DisMemberInfo param);

    public String[] getDetaiCanvas(String id);

}
