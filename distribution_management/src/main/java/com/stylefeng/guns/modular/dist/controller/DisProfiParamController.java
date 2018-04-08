package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisProfiParam;
import com.stylefeng.guns.modular.dist.service.IDisDictionaryService;
import com.stylefeng.guns.modular.dist.service.IDisProfiParamService;
import com.stylefeng.guns.modular.dist.wapper.ProfiParamWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 参数设置控制器
 *
 * @author huangpu
 * @Date 2018-04-06 11:33:32
 */
@Controller
        @RequestMapping("/disProfiParam")
public class DisProfiParamController extends BaseController {


    @Autowired
    IDisProfiParamService disProfiParamService;

    @Autowired
    IDisDictionaryService disDictionaryService;

    private String PREFIX = "/dist/disProfiParam/";

    /**
     * 跳转到参数设置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "disProfiParam.html";
    }

    /**
     * 跳转到添加参数设置
     */
    @RequestMapping("/disProfiParam_add")
    public String disProfiParamAdd(Model model) {
        model.addAttribute("disProMode",disDictionaryService.selectListByCode("disProMode"));
        model.addAttribute("disProType",disDictionaryService.selectListByCode("disProType"));
        model.addAttribute("disProLevel",disDictionaryService.selectListByCode("disProLevel"));
        model.addAttribute("disUserType",disDictionaryService.selectListByCode("disUserType"));
        return PREFIX + "disProfiParam_add.html";
    }

    /**
     * 跳转到修改参数设置
     */
    @RequestMapping("/disProfiParam_update/{disProfiParamId}")
    public String disProfiParamUpdate(@PathVariable Integer disProfiParamId, Model model) {
        return PREFIX + "disProfiParam_edit.html";
    }

    /**
     * 获取参数设置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list=disProfiParamService.selectList();
        return super.warpObject(new ProfiParamWarpper(list));
    }

    /**
     * 新增参数设置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DisProfiParam  param) {
        disProfiParamService.save(param);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除参数设置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改参数设置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 参数设置详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
