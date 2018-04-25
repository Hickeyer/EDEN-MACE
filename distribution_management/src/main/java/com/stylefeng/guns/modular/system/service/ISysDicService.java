package com.stylefeng.guns.modular.system.service;

public interface ISysDicService {


    void addDict(String dictName,String disTypeNo, String dictValues);

    void editDict(Integer dictId, String dictName,String disTypeNo, String dicts);

    void delteDict(Integer dictId);



}
