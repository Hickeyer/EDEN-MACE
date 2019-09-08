package com.dist.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperConver {
    public static Object converToObject(Object o){
        ObjectMapper mapper=new ObjectMapper();
        Object pojo = mapper.convertValue(o, Object.class);
        return pojo;
    }
}
