package com.stylefeng.guns.modular.system.controller;

import com.github.pagehelper.Page;
import com.stylefeng.guns.common.constant.factory.PageFactory;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.OperationLog;
import com.stylefeng.guns.common.persistence.model.SysJob;
import com.stylefeng.guns.modular.system.dao.SysJobDao;
import com.stylefeng.guns.modular.system.warpper.SysJobWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * 任务调度控制器
 *
 * @author xiaojiang
 * @Date 2018-09-25 17:34:21
 */
@Controller
@RequestMapping("/sysJob")
public class SysJobController extends BaseController {

    private String prefix = "/system/sysJob/";

    @Resource
    SysJobDao sysJobDao;

    /**
     * 跳转到任务调度首页
     */
    @RequestMapping("")
    public String index() {
        return prefix + "sysJob.html";
    }

    /**
     * 跳转到添加任务调度
     */
    @RequestMapping("/sysJob_add")
    public String sysJobAdd() {
        return prefix + "sysJob_add.html";
    }

    /**
     * 跳转到修改任务调度
     */
    @RequestMapping("/sysJob_update/{sysJobId}")
    public String sysJobUpdate(@PathVariable Integer sysJobId, Model model) {
        return prefix + "sysJob_edit.html";
    }

    /**
     * 获取任务调度列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page page = new PageFactory<SysJob>().defaultPage();
        List list= sysJobDao.selectList();
        List<SysJob> lists= (List<SysJob>) new SysJobWarpper(list).warp();
        return super.packForBT(lists,page.getTotal()) ;
    }

    /**
     * 新增任务调度
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {
        return SUCCESS_TIP;
    }

    /**
     * 删除任务调度
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改任务调度
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 任务调度详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
