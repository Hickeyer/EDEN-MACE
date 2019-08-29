package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
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

    private String prefix = "/dist/simOper/";

    /**
     * 跳转到模拟菜单首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "simOper.html";
    }

    /**
     * 跳转到添加模拟菜单
     */
    @RequestMapping("/simOper_add")
    public String simOperAdd() {
        return prefix + "simOper_add.html";
    }
    @RequestMapping("/withdraw_add")
    public String withdrawAdd(Model model) {
        model.addAttribute("accountType",sysDicService.selectListByCode("accountType"));
        return prefix + "withdraw_add.html";
    }

    /**
     * 会员增加页面
     * @return
     */
    @RequestMapping("/member_add")
    public String memberAdd(Model model) {
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));

        return prefix + "member_add.html";
    }

    /**
     * 订单交易增加页面
     * @return
     */
    @RequestMapping("/order_add")
    public String orderAdd(Model model) {
        model.addAttribute("accountType",sysDicService.selectListByCode("accountType"));
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));
        return prefix + "order_add.html";
    }


    /**
     * 升级页面
     * @param model
     * @return
     */
    @RequestMapping("/level_add")
    public String levelAdd(Model model) {
        model.addAttribute("upgradeLevel",sysDicService.selectListByCode("disUserType"));

        return prefix + "level_add.html";
    }
    /**
     * 跳转到修改模拟菜单
     */
    @RequestMapping("/simOper_update/{simOperId}")
    public String simOperUpdate(@PathVariable Integer simOperId, Model model) {
        return prefix + "simOper_edit.html";
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
