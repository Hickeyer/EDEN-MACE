package com.plug.xiaojiang.dist.controller;

import com.plug.xiaojiang.dist.utils.http.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @Value("${dist.server.prefix}")
    private String prefix;

    @RequestMapping({"/","/index",""})
    public String index(){
        return "/index";
    }

    @RequestMapping("/main")
    public String main(String userId){
        Object result= RestClient.create(prefix+"/getUserInfo?userId="+userId)
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .get(new ParameterizedTypeReference<Object>() {
                });
        return "/main";
    }
}
