package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisProfiParam;

import java.util.List;
import java.util.Map;

/**
 * 参数设置Service
 *
 * @author huangpu
 * @Date 2018-04-06 11:33:32
 */
public interface IDisProfiParamService {

    public List<Map<String, Object>> selectList();

    public void save(DisProfiParam param);

    public void delete(int id);

}
