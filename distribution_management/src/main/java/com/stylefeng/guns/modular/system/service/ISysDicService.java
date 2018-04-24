package com.stylefeng.guns.modular.system.service;

public interface ISysDicService {


    void addDict(String dictName, String dictValues);

    void editDict(Integer dictId, String dictName, String dicts);

    void delteDict(Integer dictId);



}
