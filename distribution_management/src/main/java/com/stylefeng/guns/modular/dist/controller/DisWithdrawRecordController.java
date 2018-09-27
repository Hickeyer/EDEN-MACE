package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DisWithdrawRecordMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.DisWithdrawRecord;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.service.IDisWithdrawRecordService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import com.stylefeng.guns.modular.dist.vo.DisWithdrawVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 提现记录控制器
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:08
 */
@Controller
@RequestMapping("/DisWithdrawRecord")
public class DisWithdrawRecordController extends BaseController {

    private String PREFIX = "/dist/DisWithdrawRecord/";

    @Autowired
    IDisMemberInfoService disMemberInfoService;

    @Autowired
    IDisWithdrawRecordService disWithdrawRecordService;

    @Autowired
    DisWithdrawRecordMapper disWithdrawRecordMapper;

    @Value("${dist.jwt.account}")
    private  String account;

    @Value("${dist.jwt.secret}")
    private  String secret;


    /**
     * 跳转到提现记录首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "DisWithdrawRecord.html";
    }

    /**
     * 跳转到添加提现记录
     */
    @RequestMapping("/DisWithdrawRecord_add")
    public String DisWithdrawRecordAdd() {
        return PREFIX + "DisWithdrawRecord_add.html";
    }
    @RequestMapping("/DisWithdrawRecord_audit/{id}")
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public String DisWithdrawRecordAudit(@PathVariable Integer id,Model model) {
        DisWithdrawRecord record= disWithdrawRecordMapper.selectById(id);
        model.addAttribute("record",record);
        return PREFIX + "DisWithdrawRecord_add.html";
    }

    /**
     * 跳转到修改提现记录
     */
    @RequestMapping("/DisWithdrawRecord_update/{DisWithdrawRecordId}")
    public String DisWithdrawRecordUpdate(@PathVariable Integer DisWithdrawRecordId, Model model) {
        return PREFIX + "DisWithdrawRecord_edit.html";
    }

    /**
     * 获取提现记录列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list=disWithdrawRecordService.selectList();
        return list;
    }

    /**
     * 新增提现记录
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public Object add(DisWithdrawVo withdrawVo) {
        DisMemberInfo memberInfo=disMemberInfoService.selectListByUserId(withdrawVo.getUserId());
        if(memberInfo==null){
            throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
        }
        String acc= Jwt.unsign(withdrawVo.getSecret(),secret,String.class);
        if(account.equals(acc)) {
            disWithdrawRecordService.withdrawMoney(withdrawVo.getUserId(),withdrawVo.getAmount(),withdrawVo.getDisProType());
        }else {
            throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
        }
        return SUCCESS_TIP;
    }

    /**
     * 删除提现记录
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改提现记录
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return SUCCESS_TIP;
    }
    @RequestMapping(value = "/audit")
    @ResponseBody
    public Object audit(Integer id,String type) {
        disWithdrawRecordService.dealWithdrawl(id,type);
        return SUCCESS_TIP;
    }

    /**
     * 提现记录详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
