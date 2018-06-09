package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisAmountSituationService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取动态信息
 */
@Controller
@RequestMapping("/dynamic")
public class DynamicController extends BaseController {

    private String PREFIX = "/dist/dynamic/";

    @Autowired
    IDisAmountSituationService disAmountSituationService;

    @RequestMapping("")
    public String index(Model model) {
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        model.addAttribute("model",disAmountSituationService.getDynamicInfo(account));
        return PREFIX + "dynamic.html";
    }
}
