package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 记账表控制器
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:44
 */
@Controller
@RequestMapping("/DisAmountSituation")
public class DisAmountSituationController extends BaseController {

    private String prefix = "/dist/DisAmountSituation/";

    /**
     * 跳转到记账表首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "DisAmountSituation.html";
    }

    /**
     * 跳转到添加记账表
     */
    @RequestMapping("/DisAmountSituation_add")
    public String disAmountSituationAdd() {
        return prefix + "DisAmountSituation_add.html";
    }

    /**
     * 跳转到修改记账表
     */
    @RequestMapping("/DisAmountSituation_update/{DisAmountSituationId}")
    public String disAmountSituationUpdate(@PathVariable Integer disAmountSituationId, Model model) {
        return prefix + "DisAmountSituation_edit.html";
    }

    /**
     * 获取记账表列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增记账表
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return SUCCESS_TIP;
    }

    /**
     * 删除记账表
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改记账表
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 记账表详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
