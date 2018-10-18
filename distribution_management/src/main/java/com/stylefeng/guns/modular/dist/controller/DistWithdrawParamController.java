package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DistWithdrawParam;
import com.stylefeng.guns.modular.dist.service.IDistWithdrawParamService;
import com.stylefeng.guns.modular.dist.wapper.DistWithdrawParamWarpper;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 提现参数设置控制器
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:54:36
 */
@Controller
@RequestMapping("/DistWithdrawParam")
public class DistWithdrawParamController extends BaseController {

    private String prefix = "/dist/DistWithdrawParam/";

    @Autowired
    IDistWithdrawParamService distWithdrawParamService;

    @Autowired
    ISysDicService sysDicService;

    /**
     * 跳转到提现参数设置首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "DistWithdrawParam.html";
    }

    /**
     * 跳转到添加提现参数设置
     */
    @RequestMapping("/DistWithdrawParam_add")
    public String distWithdrawParamAdd(Model model) {
        model.addAttribute("calModel",sysDicService.selectListByCode("calModel"));
        return prefix + "DistWithdrawParam_add.html";
    }

    /**
     * 跳转到修改提现参数设置
     */
    @RequestMapping("/DistWithdrawParam_update/{DistWithdrawParamId}")
    public String distWithdrawParamUpdate(@PathVariable Integer distWithdrawParamId, Model model) {
        return prefix + "DistWithdrawParam_edit.html";
    }

    /**
     * 获取提现参数设置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list= distWithdrawParamService.selectList();
        return super.warpObject(new DistWithdrawParamWarpper(list));
    }

    /**
     * 新增提现参数设置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DistWithdrawParam distWithdrawParam) {
        distWithdrawParamService.save(distWithdrawParam);
        return SUCCESS_TIP;
    }

    /**
     * 删除提现参数设置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer id) {
        distWithdrawParamService.delete(id);
        return SUCCESS_TIP;
    }


    /**
     * 修改提现参数设置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 提现参数设置详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
