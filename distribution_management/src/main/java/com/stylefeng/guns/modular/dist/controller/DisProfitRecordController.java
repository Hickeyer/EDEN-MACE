package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisProfitRecordService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import com.stylefeng.guns.modular.dist.wapper.ProfiParamWarpper;
import com.stylefeng.guns.modular.dist.wapper.ProfitRecordWarpper;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    private String PREFIX = "/dist/disProfitRecord/";

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
        List<Map<String, Object>> list=disProfitRecordService.selectList();
        return super.warpObject(new ProfitRecordWarpper(list));
    }

    /**
     * 新增交易
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation(value = "新增交易", notes = "")
    public Object add(@RequestBody DisProfitRecordVo disProfitRecordVo) {

        User user=userMgrDao.getByAccount(disProfitRecordVo.getDisPlatformId());
        if(user==null){
            throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
        }
        String secret= Jwt.sign(ShiroKit.getUser().getAccount(),user.getSecret(),30L * 24L * 3600L * 1000L);
        String account=Jwt.unsign(disProfitRecordVo.getSecret(),user.getSecret(),String.class);
        if(account.equals(disProfitRecordVo.getDisPlatformId())) {
            disProfitRecordService.save(disProfitRecordVo);
        }else {
            throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
        }
        return super.SUCCESS_TIP;
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
        return super.SUCCESS_TIP;
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
