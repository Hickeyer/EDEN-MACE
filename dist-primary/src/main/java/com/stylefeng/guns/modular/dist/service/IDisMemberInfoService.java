package com.stylefeng.guns.modular.dist.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.modular.dist.http.request.SubordinateReq;
import com.stylefeng.guns.modular.dist.http.response.SubordinateResp;

import java.util.List;
import java.util.Map;

/**
 * 分销Service
 *
 * @author huangpu
 * @Date 2018-04-05 21:49:44
 */
public interface IDisMemberInfoService {

    List<Map<String, Object>> selectList(String account, String disUserId, String disModelId);

    /**
     * 根据用户名查询用户
     * @return
     */
    DisMemberInfo selectListByUserId(String userId);

    String[] getDetaiCanvas(String id);

    public void save(DisMemberInfo param) throws Exception;

    public void saveAgent(DisMemberInfo param);

    public void updateLevel(DisMemberInfo param);


    /**
     * 查询下级会员
     * @param req
     * @return
     */
    public List<SubordinateResp> getSubordinateInfo(SubordinateReq req);

    public void saveNoOperate(DisMemberInfo param);

    public String getTreeList(String memmberId);

}
