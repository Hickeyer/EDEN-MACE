package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.modular.system.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 模拟菜单控制器
 *
 * @author xiaojiang
 * @Date 2018-05-05 17:02:43
 */
@Controller
@RequestMapping("/simOper")
public class SimOperController extends BaseController {

    @Autowired
    ISysDicService sysDicService;

    private String PREFIX = "/dist/simOper/";

    /**
     * 跳转到模拟菜单首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "simOper.html";
    }

    /**
     * 跳转到添加模拟菜单
     */
    @RequestMapping("/simOper_add")
    public String simOperAdd() {
        return PREFIX + "simOper_add.html";
    }
    @RequestMapping("/withdraw_add")
    public String withdraw_add(Model model) {
        model.addAttribute("disProType",sysDicService.selectListByCode("disProType"));
        return PREFIX + "withdraw_add.html";
    }

    /**
     * 会员增加页面
     * @return
     */
    @RequestMapping("/member_add")
    public String member_add(Model model) {
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));

        return PREFIX + "member_add.html";
    }

    /**
     * 订单交易增加页面
     * @return
     */
    @RequestMapping("/order_add")
    public String order_add(Model model) {
        model.addAttribute("disProType",sysDicService.selectListByCode("disProType"));
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));
        return PREFIX + "order_add.html";
    }

    /**
     * 跳转到修改模拟菜单
     */
    @RequestMapping("/simOper_update/{simOperId}")
    public String simOperUpdate(@PathVariable Integer simOperId, Model model) {
        return PREFIX + "simOper_edit.html";
    }

    /**
     * 获取模拟菜单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增模拟菜单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return SUCCESS_TIP;
    }

    /**
     * 删除模拟菜单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改模拟菜单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 模拟菜单详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
