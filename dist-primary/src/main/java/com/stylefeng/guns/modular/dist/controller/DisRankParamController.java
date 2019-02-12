package com.stylefeng.guns.modular.dist.controller;

import com.github.pagehelper.Page;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.factory.PageFactory;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisRankParam;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisRankParamService;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import com.stylefeng.guns.modular.dist.wapper.CommonWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 段位积分控制器
 *
 * @author xiaojiang
 * @Date 2018-07-19 22:08:00
 */
@Controller
@RequestMapping("/DisRankParam")
public class DisRankParamController extends BaseController {

    private String prefix = "/dist/DisRankParam/";

    @Autowired
    IDisRankParamService disRankParamService;


    @Autowired
    ISysDicService sysDicService;

    /**
     * 跳转到段位积分首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("calModel",sysDicService.selectListByCode("calModel"));
        model.addAttribute("accountType",sysDicService.selectListByCode("accountType"));
        model.addAttribute("disProLevel",sysDicService.selectListByCode("disRankLevel"));
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));
        model.addAttribute("disUserRank",sysDicService.selectListByCode("disUserRank"));
        return prefix + "DisRankParam.html";
    }

    /**
     * 跳转到添加段位积分
     */
    @RequestMapping("/DisRankParam_add")
    public String disRankParamAdd(Model model) {
        model.addAttribute("calModel",sysDicService.selectListByCode("calModel"));
        model.addAttribute("accountType",sysDicService.selectListByCode("accountType"));
        model.addAttribute("disProLevel",sysDicService.selectListByCode("disRankLevel"));
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));
        model.addAttribute("disUserRank",sysDicService.selectListByCode("disUserRank"));
        return prefix + "DisRankParam_add.html";
    }

    /**
     * 跳转到修改段位积分
     */
    @RequestMapping("/DisRankParam_update/{disRankParamId}")
    public String disRankParamUpdate(@PathVariable Integer disRankParamId, Model model) {
        DisRankParam disRankParam = disRankParamService.selectOne(disRankParamId);
        model.addAttribute("id",disRankParamId);
        model.addAttribute("disRankName",disRankParam.getDisRankName());
        model.addAttribute("disIntegralValue",disRankParam.getDisIntegralValue());
        return prefix + "DisRankParam_edit.html";
    }

    /**
     * 获取段位积分列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String calModel,String accountType,String disUserType,String disUserRank) {
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        Page page = new PageFactory().defaultPage();
        List<Map<String, Object>> list = disRankParamService.selectList(account,calModel, accountType, disUserType, disUserRank);
        List<DisRankParam> lists = (List<DisRankParam> )new CommonWarpper(list).warp();
        return super.packForBT(lists,page.getTotal()) ;
    }

    /**
     * 新增段位积分
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DisRankParam param) {
        String account= ShiroKit.getUser().getAccount();
        if(!ShiroKit.hasRole(Const.ADMIN_NAME)){
            param.setDisPlatformId(account);
        }
        disRankParamService.save(param);
        return SUCCESS_TIP;
    }

    /**
     * 删除段位积分
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam int id) {
        disRankParamService.delete(id);
        return SUCCESS_TIP;
    }


    /**
     * 修改段位积分
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DisRankParam param) {
        disRankParamService.update(param);
        return SUCCESS_TIP;
    }

    /**
     * 段位积分详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
