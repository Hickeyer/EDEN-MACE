package com.plug.xiaojiang.dist.controller;

import com.dist.api.SendToDistService;
import com.dist.api.common.tip.DistResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.plug.xiaojiang.dist.model.DisMemberAmount;
import com.plug.xiaojiang.dist.model.DisMemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {


    @Autowired
    SendToDistService sendToDistService;

    @Value("${dist.server.prefix}")
    private String prefix;

    @RequestMapping({"/","/index",""})
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "self";
    }
    @RequestMapping("/login")
    public String home(String userId, HttpServletRequest request){
        DistResult result= sendToDistService.getUserInfo(prefix,userId);
        if(result.isSuccess()){
            Map<String ,Object> map= (Map<String, Object>) result.getData();
            Gson gson = new Gson();
            String memberJson = gson.toJson(map.get("member")).toString();
            DisMemberInfo member = gson.fromJson(memberJson,DisMemberInfo.class);
            String amountJson = gson.toJson(map.get("amount")).toString();
            DisMemberAmount amount= gson.fromJson(amountJson,DisMemberAmount.class);
            request.getSession().setAttribute("member",member);
            request.getSession().setAttribute("amount",amount);
        }else{
            System.out.println("登录失败");
            return "index";
        }
        return "self";
    }
}
