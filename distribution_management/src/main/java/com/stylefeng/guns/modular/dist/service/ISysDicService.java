package com.stylefeng.guns.modular.dist.service;

import java.util.List;
import java.util.Map;

/**
 * @author huangpu
 */
public interface ISysDicService {


    void addDict(String dictName,String disTypeNo, String dictValues);

    void editDict(Integer dictId, String dictName,String disTypeNo, String dicts);

    void delteDict(Integer dictId);


    public List<Map<String, Object>> selectListByCode(String code);
    public Map<String, Object> selectListByCodeNo(String code,String no);


    public String getOrderNo(String codeNo);


}
