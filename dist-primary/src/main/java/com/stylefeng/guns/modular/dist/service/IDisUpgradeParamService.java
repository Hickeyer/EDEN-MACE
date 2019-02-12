package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisUpgradeParam;

import java.util.List;
import java.util.Map;

/**
 * 垂直升级配置Service
 *
 * @author xiaojiang
 * @Date 2018-07-23 16:07:11
 */
public interface IDisUpgradeParamService {

    public List<Map<String, Object>> selectList(String upgradeName);
    public List<Map<String, Object>> selectAgentList(String upgradeName);

    public void save(DisUpgradeParam param);

    public void deleteById(Integer id);

}
