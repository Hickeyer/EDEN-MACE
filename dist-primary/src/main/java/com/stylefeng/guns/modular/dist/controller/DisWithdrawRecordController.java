package com.stylefeng.guns.modular.dist.controller;

import com.github.pagehelper.Page;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.factory.PageFactory;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.dao.DisWithdrawRecordMapper;
import com.stylefeng.guns.common.persistence.model.DisWithdrawRecord;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.service.IDisWithdrawRecordService;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import com.stylefeng.guns.modular.dist.wapper.CommonWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
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

    private String prefix = "/dist/DisWithdrawRecord/";

    @Autowired
    IDisMemberInfoService disMemberInfoService;

    @Autowired
    IDisWithdrawRecordService disWithdrawRecordService;

    @Resource
    DisWithdrawRecordMapper disWithdrawRecordMapper;

    @Autowired
    ISysDicService sysDicService;

    @Value("${dist.jwt.account}")
    private  String account;

    @Value("${dist.jwt.secret}")
    private  String secret;


    /**
     * 跳转到提现记录首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("accountType",sysDicService.selectListByCode("accountType"));
        return prefix + "DisWithdrawRecord.html";
    }

    /**
     * 跳转到添加提现记录
     */
    @RequestMapping("/DisWithdrawRecord_add")
    public String disWithdrawRecordAdd() {
        return prefix + "DisWithdrawRecord_add.html";
    }
    @RequestMapping("/DisWithdrawRecord_audit/{id}")
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public String disWithdrawRecordAudit(@PathVariable Integer id,Model model) {
        DisWithdrawRecord record= disWithdrawRecordMapper.selectById(id);
        model.addAttribute("record",record);
        return prefix + "DisWithdrawRecord_add.html";
    }

    /**
     * 跳转到修改提现记录
     */
    @RequestMapping("/DisWithdrawRecord_update/{disWithdrawRecordId}")
    public String disWithdrawRecordUpdate(@PathVariable Integer disWithdrawRecordId, Model model) {
        return prefix + "DisWithdrawRecord_edit.html";
    }

    /**
     * 获取提现记录列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String disUserId,String withdrawNum,String withdrawStatus,String accountType) {
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        Page page = new PageFactory().defaultPage();
        List<Map<String, Object>> list=disWithdrawRecordService.selectList( account, disUserId, withdrawNum, withdrawStatus, accountType);
        return super.packForBT((List)new CommonWarpper(list).warp(),page.getTotal());
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
