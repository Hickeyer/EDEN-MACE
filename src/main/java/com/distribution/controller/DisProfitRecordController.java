package com.distribution.controller;

import com.distribution.common.model.DisProfitRecord;
import com.distribution.common.util.InvokeResult;
import com.distribution.model.DisProfitRecordVo;
import com.distribution.service.DisDictionaryService;
import com.distribution.service.DisProfitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangpu on 2017/6/9.
 */
@Controller
@RequestMapping("/disProfit")
public class DisProfitRecordController extends CommonController {

    @Autowired
    DisProfitRecordService disProfitRecordService;

    @Autowired
    DisDictionaryService disDictionaryService;

    @GetMapping("/add")
    public String add(HttpServletRequest request){
        request.setAttribute("disProType",disDictionaryService.selectListByCode("disProType"));
        return "/html/order/simulationOrder";
    }

    @PostMapping("/add")
    @ResponseBody
    public InvokeResult addPost(DisProfitRecordVo vo){
        try {
            disProfitRecordService.save(vo);
            return  InvokeResult.success();
        }catch (Exception e){
            return InvokeResult.failure(e.getMessage());
        }
    }

    @GetMapping("/list")
    public  String list(){
        return "html/order/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public InvokeResult listPost(DisProfitRecord param){
        try {
            return InvokeResult.success(disProfitRecordService.list(param));
        }catch (Exception e){
            return InvokeResult.failure(e.getMessage());
        }
    }


}
