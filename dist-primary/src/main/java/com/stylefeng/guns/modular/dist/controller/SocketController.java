package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.modular.dist.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/socket")
public class SocketController extends BaseController{


    @Autowired
    IStatisticsService statisticsService;

    @RequestMapping("/statistics")
    public String statistics(Model model) {
        return "/dist/socket/statisticsSocket.html";
    }
    @RequestMapping("/http/statis")
    @ResponseBody
    public String httpStatis(Model model) {
        String msg = statisticsService.findStatisticsInfo();
        return msg;
    }


}
