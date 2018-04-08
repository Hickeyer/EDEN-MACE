package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisMemberInfoDao;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.util.Jwt;
import com.stylefeng.guns.modular.dist.vo.DisMemberInfoVo;
import com.stylefeng.guns.modular.dist.wapper.MemberWarpper;
import com.stylefeng.guns.modular.system.dao.UserMgrDao;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 会员表控制器
 *
 * @author huangpu
 * @Date 2018-04-05 21:49:44
 */
@Controller
@RequestMapping("/disMemberInfo")
public class DisMemberInfoController extends BaseController {

    private String PREFIX = "/dist/disMemberInfo/";

    @Autowired
    IDisMemberInfoService  disMemberInfoService;

    @Autowired
    UserMgrDao userMgrDao;

    /**
     * 跳转到分销首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "disMemberInfo.html";
    }

    /**
     * 跳转到添加分销
     */
    @RequestMapping("/disMemberInfo_add")
    public String disMemberInfoAdd() {
        return PREFIX + "disMemberInfo_add.html";
    }

    /**
     * 跳转到修改分销
     */
    @RequestMapping("/disMemberInfo_update/{disMemberInfoId}")
    public String disMemberInfoUpdate(@PathVariable Integer disMemberInfoId, Model model) {
        return PREFIX + "disMemberInfo_edit.html";
    }
    @RequestMapping("/view/{id}")
    public String memberView(HttpServletRequest request, @PathVariable String id, Model model) {

        String[] detailInfo=disMemberInfoService.getDetaiCanvas(id);
        model.addAttribute("node",detailInfo[0]);
        model.addAttribute("link",detailInfo[1]);
        request.setAttribute("node",detailInfo[0]);
        request.setAttribute("link",detailInfo[1]);
        return PREFIX + "detail.html";
    }

    /**
     * 获取分销列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>>  list=disMemberInfoService.selectList();
        return super.warpObject(new MemberWarpper(list));
    }

    /**
     * 新增分销
     */
    @PostMapping(value = "/add")
    @ResponseBody
    @ApiOperation(value = "新增会员", notes = "")
    public Object add(@RequestBody DisMemberInfoVo memberInfoVo) {
        User user=userMgrDao.getByAccount(memberInfoVo.getDisPlatformId());
        if(user==null){
            throw  new BussinessException(BizExceptionEnum.USER_NOT_EXISTED);
        }
        String secret= Jwt.sign(ShiroKit.getUser().getAccount(),user.getSecret(),30L * 24L * 3600L * 1000L);
        String account=Jwt.unsign(memberInfoVo.getSecret(),user.getSecret(),String.class);
        if(account.equals(memberInfoVo.getDisPlatformId())){
            DisMemberInfo memberInfo=new DisMemberInfo();
            BeanUtils.copyProperties(memberInfoVo,memberInfo);
            disMemberInfoService.save(memberInfo);
        }else {
            throw new BussinessException(BizExceptionEnum.ILLEGAL_INFO);
        }
        return super.SUCCESS_TIP;
    }

    /**
     * 删除分销
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改分销
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 分销详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
