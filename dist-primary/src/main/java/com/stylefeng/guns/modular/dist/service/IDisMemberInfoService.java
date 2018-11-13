package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisMemberInfo;

import java.util.List;
import java.util.Map;

/**
 * 分销Service
 *
 * @author huangpu
 * @Date 2018-04-05 21:49:44
 */
public interface IDisMemberInfoService {

    List<Map<String, Object>> selectList(String account);

    /**
     * 根据用户名查询用户
     * @return
     */
    DisMemberInfo selectListByUserId(String userId);

    String[] getDetaiCanvas(String id);

    public void save(DisMemberInfo param);

    public void saveAgent(DisMemberInfo param);

    public void updateLevel(DisMemberInfo param);

}
