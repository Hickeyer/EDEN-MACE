package com.plug.xiaojiang.dist.controller;

import com.plug.xiaojiang.dist.annotation.DistMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @DistMember
    @RequestMapping("/test")
    public String test(String amount,String hello){
        System.out.println("testController");
        return "";
    }
}
