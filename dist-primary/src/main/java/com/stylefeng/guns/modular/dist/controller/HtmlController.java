package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.constant.dist.UserTypeStatus;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.service.ITaskService;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author  xiaojiang
 */
@Controller
public class HtmlController extends BaseController {

    @Autowired
    ITaskService taskService;



    @Resource
    private UserMgrDao managerDao;



    @PostMapping("/clearData")
    @ResponseBody
    public  String clearData(){
        //查询admin，初始化admin账户信息
        String account ="admin";
        User user= managerDao.getByAccount(account);
        //删除分销表的信息
        taskService.clearData(user);
        taskService.clearAuthDB();
        return "sucess";
    }

}
