package com.distribution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by huangpu on 2017/6/6.
 */
@Controller
public class IndexController extends CommonController {

    @GetMapping(value = {"index",""})
    public String index(){
        return "index";
    }
    @GetMapping(value = {"test"})
    public String test(){
        return "test";
    }


}
