package com.stylefeng.guns.modular.dist.service;

import java.util.List;
import java.util.Map;

/**
 * 账户管理Service
 *
 * @author xiaojiang
 * @Date 2018-05-08 21:16:47
 */
public interface IDisMemberAmountService {

    public void save(String userId,String userName,String type);

    List<Map<String, Object>> selectList(String platformId);
}
