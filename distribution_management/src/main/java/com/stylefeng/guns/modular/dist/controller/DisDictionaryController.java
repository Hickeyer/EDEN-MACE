package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 字典控制器
 *
 * @author fengshuonan
 * @Date 2018-04-06 13:57:03
 */
@Controller
@RequestMapping("/DisDictionary")
public class DisDictionaryController extends BaseController {

    private String PREFIX = "/dist/DisDictionary/";

    /**
     * 跳转到字典首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "DisDictionary.html";
    }

    /**
     * 跳转到添加字典
     */
    @RequestMapping("/DisDictionary_add")
    public String DisDictionaryAdd() {
        return PREFIX + "DisDictionary_add.html";
    }

    /**
     * 跳转到修改字典
     */
    @RequestMapping("/DisDictionary_update/{DisDictionaryId}")
    public String DisDictionaryUpdate(@PathVariable Integer DisDictionaryId, Model model) {
        return PREFIX + "DisDictionary_edit.html";
    }

    /**
     * 获取字典列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增字典
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return super.SUCCESS_TIP;
    }

    /**
     * 删除字典
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改字典
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 字典详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
