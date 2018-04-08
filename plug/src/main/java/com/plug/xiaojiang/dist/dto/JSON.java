package com.plug.xiaojiang.dist.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper get() {
        return mapper;
    }
}
