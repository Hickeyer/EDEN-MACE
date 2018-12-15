package com.plug.xiaojiang.dist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {



    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/invite")
    public String invite(){
        return "trade/invite";
    }
    @RequestMapping("/trade")
    public String trade(){
        return "trade/trade";
    }

    @GetMapping("/subordinate")
    public String subordinate(){
        return "my/subordinate";
    }
}
