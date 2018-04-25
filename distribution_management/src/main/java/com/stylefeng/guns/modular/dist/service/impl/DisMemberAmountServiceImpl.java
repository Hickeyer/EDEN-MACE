package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class DisMemberAmountServiceImpl implements IDisMemberAmountService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(String param) {
        mongoTemplate.save(param,"amount");
    }
}
