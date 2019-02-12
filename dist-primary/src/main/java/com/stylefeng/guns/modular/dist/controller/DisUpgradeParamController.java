package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisUpgradeParam;
import com.stylefeng.guns.modular.dist.service.IDisUpgradeParamService;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 垂直升级配置控制器
 *
 * @author xiaojiang
 * @Date 2018-07-23 16:07:11
 */
@Controller
@RequestMapping("/DisUpgradeParam")
public class DisUpgradeParamController extends BaseController {

    @Autowired
    ISysDicService sysDicService;

    @Autowired
    IDisUpgradeParamService disUpgradeParamService;

    private String prefix = "/dist/DisUpgradeParam/";

    private String prefix2 = "/dist/DisUpgradeAgentParam/";

    /**
     * 跳转到垂直升级配置首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "DisUpgradeParam.html";
    }
    @RequestMapping("/agent")
    public String agent() {
        return prefix2 + "DisUpgradeParam.html";
    }

    /**
     * 跳转到添加垂直升级配置
     */
    @RequestMapping("/DisUpgradeParam_add")
    public String disUpgradeParamAdd(Model model) {
        model.addAttribute("disUserRank",sysDicService.selectListByCode("disUserRank"));
        return prefix + "DisUpgradeParam_add.html";
    }
    @RequestMapping("/agent/DisUpgradeParam_add")
    public String disUpgradeAgentParamAdd(Model model) {
        model.addAttribute("disUserRank",sysDicService.selectListByCode("agentRank"));
        return prefix2 + "DisUpgradeParam_add.html";
    }

    /**
     * 跳转到修改垂直升级配置
     */
    @RequestMapping("/DisUpgradeParam_update/{disUpgradeParamId}")
    public String disUpgradeParamUpdate(@PathVariable Integer disUpgradeParamId, Model model) {
        return prefix + "DisUpgradeParam_edit.html";
    }

    /**
     * 获取垂直升级配置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String upgradeName) {
        if(StringUtils.isNotEmpty(upgradeName)){
            upgradeName ="%"+upgradeName+"%";
        }
        return disUpgradeParamService.selectList(upgradeName);
    }

    /**
     * 查询代理商列表
     * @param upgradeName
     * @return
     */
    @RequestMapping(value = "/agent/list")
    @ResponseBody
    public Object listAgent(String upgradeName) {
        if(StringUtils.isNotEmpty(upgradeName)){
            upgradeName ="%"+upgradeName+"%";
        }
        return disUpgradeParamService.selectAgentList(upgradeName);
    }

    /**
     * 新增垂直升级配置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DisUpgradeParam param) {
        disUpgradeParamService.save(param);
        return SUCCESS_TIP;
    }
    @RequestMapping(value = "/agent/add")
    @ResponseBody
    public Object addAgent(DisUpgradeParam param) {
        param.setIdentityType("1");
        disUpgradeParamService.save(param);
        return SUCCESS_TIP;
    }

    /**
     * 删除垂直升级配置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer id) {
        disUpgradeParamService.deleteById(id);
        return SUCCESS_TIP;
    }
    @RequestMapping(value = "/agent/delete")
    @ResponseBody
    public Object agentDelete(Integer id) {
        disUpgradeParamService.deleteById(id);
        return SUCCESS_TIP;
    }


    /**
     * 修改垂直升级配置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 垂直升级配置详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
