package com.stylefeng.guns.modular.dist.service;

import java.util.List;
import java.util.Map;

public interface IDisMemberAmountService {

    public void save(String userId,String userName,String disPlatformId);


    public List<Object> list(String param);


    List<Map<String, Object>> selectList();
}
