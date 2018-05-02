package com.stylefeng.guns.modular.dist.controller;

import com.google.gson.Gson;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 会员账户管理控制器
 *
 * @author huangpu
 * @Date 2018-05-02 19:21:08
 */
@Controller
@RequestMapping("/disMemberAmount")
public class DisMemberAmountController extends BaseController {

    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @Autowired
    IDisMemberInfoService disMemberInfoService;

    private String PREFIX = "/dist/disMemberAmount/";

    /**
     * 跳转到会员账户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "disMemberAmount.html";
    }

    /**
     * 跳转到添加会员账户管理
     */
    @RequestMapping("/disMemberAmount_add")
    public String disMemberAmountAdd() {
        return PREFIX + "disMemberAmount_add.html";
    }

    /**
     * 跳转到修改会员账户管理
     */
    @RequestMapping("/disMemberAmount_update/{disMemberAmountId}")
    public String disMemberAmountUpdate(@PathVariable Integer disMemberAmountId, Model model) {
        return PREFIX + "disMemberAmount_edit.html";
    }

    /**
     * 获取会员账户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list=disMemberAmountService.selectList();
        return list;
    }

    /**
     * 同步会员信息
     * @return
     */
    @RequestMapping(value = "/synchInfo")
    @ResponseBody
    public Object synchInfo() {
        List<Map<String, Object>>  list=disMemberInfoService.selectList();
        if(list.size()>0){
            list.forEach(map->{
                disMemberAmountService.save(map.get("disUserId").toString()
                        ,map.get("disUserName").toString(),map.get("disPlatformId").toString());
            });
        }
        return list;
    }

    /**
     * 新增会员账户管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() {

        //测试新增，后面的会员新增会根据用户的交易情况进行增加
       /* DisMemberInfo info=new DisMemberInfo();
        info.setDisLevel(1);
        info.setDisPlatformId("a");
        Gson gson=new Gson();
        disMemberAmountService.save(gson.toJson(info));*/
        return super.SUCCESS_TIP;
    }

    /**
     * 删除会员账户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改会员账户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 会员账户管理详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
