package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.service.IDisProfitRecordService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import com.stylefeng.guns.modular.dist.wapper.ProfiParamWarpper;
import com.stylefeng.guns.modular.dist.wapper.ProfitRecordWarpper;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * 交易控制器
 *
 * @author huangpu
 * @Date 2018-04-06 12:19:23
 */
@Controller
@RequestMapping("/disProfitRecord")
public class DisProfitRecordController extends BaseController {

    @Autowired
    IDisProfitRecordService disProfitRecordService;

    @Autowired
    UserMgrDao userMgrDao;

    @Autowired
    IDisMemberInfoService disMemberInfoService;

    private String PREFIX = "/dist/disProfitRecord/";


    @Value("${dist.jwt.secret}")
    private  String secret;
    @Value("${dist.jwt.account}")
    private  String account;


    /**
     * 跳转到交易首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "disProfitRecord.html";
    }

    /**
     * 跳转到添加交易
     */
    @RequestMapping("/disProfitRecord_add")
    public String disProfitRecordAdd() {
        return PREFIX + "disProfitRecord_add.html";
    }

    /**
     * 跳转到修改交易
     */
    @RequestMapping("/disProfitRecord_update/{disProfitRecordId}")
    public String disProfitRecordUpdate(@PathVariable Integer disProfitRecordId, Model model) {
        return PREFIX + "disProfitRecord_edit.html";
    }

    /**
     * 获取交易列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        List<Map<String, Object>> list=disProfitRecordService.selectList(account);
        return super.warpObject(new ProfitRecordWarpper(list));
    }



    /**
     * 删除交易
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改交易
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }

    /**
     * 交易详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
