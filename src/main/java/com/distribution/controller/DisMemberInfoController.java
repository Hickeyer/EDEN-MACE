package com.distribution.controller;

import com.distribution.common.model.DisMemberInfo;
import com.distribution.common.util.InvokeResult;
import com.distribution.service.DisDictionaryService;
import com.distribution.service.DisMemberInfoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangpu on 2017/6/2.
 */
@Controller
@RequestMapping("/dismember")
public class DisMemberInfoController  extends CommonController {

    @Value("${jdbc.driverClassName}")
    private  String className;

    @Autowired
    DisDictionaryService disDictionaryService;

    @Autowired
    DisMemberInfoService disMemberInfoService;

    @GetMapping(value = "/detail/{id}")
    public String detail(HttpServletRequest request,@PathVariable String id){
        String[] detailInfo=disMemberInfoService.getDetaiCanvas(id);
        Gson gson=new Gson();
        request.setAttribute("node",detailInfo[0]);
        request.setAttribute("link",detailInfo[1]);
        return "/html/member/detail";
    }
    @PostMapping("/nodeList")
    public String nodeList(String id){
        String[] detailInfo=disMemberInfoService.getDetaiCanvas(id);
        return detailInfo[1];
    }
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public  String insert(HttpServletRequest request){
        request.setAttribute("disUserType",disDictionaryService.selectListByCode("disUserType"));
        return "/html/member/insert";
    }
    @GetMapping("/list")
    public String list(){
        return "html/member/list";
    }
    @PostMapping("/list")
    @ResponseBody
    public InvokeResult listPost(DisMemberInfo memberInfo){
     try {
         return InvokeResult.success(disMemberInfoService.getMemberList(memberInfo));
     }catch (Exception e){
         return InvokeResult.failure(e.getMessage());
     }
    }

    @PostMapping(value = "insert")
    @ResponseBody
    public InvokeResult insertpost(DisMemberInfo memberInfo){
        try {
            disMemberInfoService.save(memberInfo);
           return InvokeResult.success();
        }catch (Exception e){
            return InvokeResult.failure(e.getMessage());
        }
    }
}
