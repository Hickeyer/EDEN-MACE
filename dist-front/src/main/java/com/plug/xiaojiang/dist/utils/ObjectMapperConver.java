package com.plug.xiaojiang.dist.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plug.xiaojiang.dist.model.DisMemberInfo;

public class ObjectMapperConver {
    public static Object converToObject(Object o){
        ObjectMapper mapper=new ObjectMapper();
        Object pojo = mapper.convertValue(o, Object.class);
        return pojo;
    }
}
