package com.stylefeng.guns.modular.dist.controller;

import com.google.gson.Gson;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/amount")
public class DisMemberAmountController extends BaseController {

    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @RequestMapping("/add")
    public String index() {
        DisMemberInfo info=new DisMemberInfo();
        info.setDisLevel(1);
        info.setDisPlatformId("a");
        Gson gson=new Gson();
        disMemberAmountService.save(gson.toJson(info));
        return "test";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Object> list(){
        return disMemberAmountService.list("");
    }


}
