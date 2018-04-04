package com.distribution.controller;

import com.distribution.common.model.DisDictionary;
import com.distribution.common.model.DisProfiParam;
import com.distribution.common.util.InvokeResult;
import com.distribution.service.DisDictionaryService;
import com.distribution.service.DisProfiParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by huangpu on 2017/6/5.
 */
@Controller
@RequestMapping("/dispro")
public class DisProfiParamController  extends CommonController {

    @Autowired
    DisProfiParamService disProfiParamService;

    @Autowired
    DisDictionaryService disDictionaryService;

    @GetMapping("/add")
    public String add(HttpServletRequest request){
        List<DisDictionary> list=disDictionaryService.selectListByCode("disProLevel");
        request.setAttribute("disProMode",disDictionaryService.selectListByCode("disProMode"));
        request.setAttribute("disProType",disDictionaryService.selectListByCode("disProType"));
        request.setAttribute("disProLevel",disDictionaryService.selectListByCode("disProLevel"));
        request.setAttribute("disUserType",disDictionaryService.selectListByCode("disUserType"));
        return "/html/profi/add";
    }
    @GetMapping("/list")
    public String list(){
        return "/html/profi/list";
    }

    @PostMapping("/add")
    @ResponseBody
    public InvokeResult addPost(DisProfiParam profiParam){
        try {
            disProfiParamService.save(profiParam);
            return InvokeResult.success();
        }catch (Exception e){
            return InvokeResult.failure(e.getMessage());
        }
    }

    @PostMapping("list")
    @ResponseBody
    public InvokeResult listPost(HttpServletRequest request,DisProfiParam profiParam){
        try {
            return InvokeResult.success(disProfiParamService.selectList(profiParam));
        }catch (Exception e){
            return InvokeResult.failure(e.getMessage());
        }

    }

}
