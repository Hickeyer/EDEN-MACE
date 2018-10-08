package com.stylefeng.guns.modular.dist.controller;

import com.google.gson.Gson;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisAmountSituationService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 获取动态信息
 */
@Controller
@RequestMapping("/dynamic")
public class DynamicController extends BaseController {

    private String prefix = "/dist/dynamic/";

    @Autowired
    IDisAmountSituationService disAmountSituationService;

    @RequestMapping("")
    public String index(Model model) {
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        model.addAttribute("model",disAmountSituationService.getDynamicInfo(account));
        return prefix + "dynamic.html";
    }
    @RequestMapping("/myaccount")
    public String myaccount(Model model) {
        String account= ShiroKit.getUser().getAccount();
        Map<String,Object> map=disAmountSituationService.myaccount(account);
        List<String> date=(List)map.get("date");
        List<String> amount=(List)map.get("amount");
        List<String> after=(List)map.get("after");
        Gson gson=new Gson();
        model.addAttribute("date",gson.toJson(date).toString());
        model.addAttribute("amount",gson.toJson(amount).toString());
        model.addAttribute("after",gson.toJson(after).toString());
        return prefix + "myaccount.html";
    }
}
