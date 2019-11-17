package com.plug.xiaojiang.dist.controller;

import com.dist.api.SendToDistService;
import com.dist.api.common.tip.DistResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.plug.xiaojiang.dist.dto.DisMemberInfoVo;
import com.plug.xiaojiang.dist.dto.DisProfitRecordVo;
import com.plug.xiaojiang.dist.http.request.SubordinateReq;
import com.plug.xiaojiang.dist.model.DisMemberAmount;
import com.plug.xiaojiang.dist.model.DisMemberInfo;
import com.plug.xiaojiang.dist.utils.PinYinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Value("${dist.server.prefix}")
    private String prefix;
    @Value("${dist.server.secret}")
    private String secret;

    @Autowired
    SendToDistService sendToDistService;


    @RequestMapping("/inviteUser")
    @ResponseBody
    public DistResult inviteUser(String userName, HttpServletRequest request){
        DisMemberInfo memberInfo= (DisMemberInfo) request.getSession().getAttribute("member");
        if(memberInfo==null){
            return DistResult.failure("请登录！");
        }
        DisMemberInfoVo vo=new DisMemberInfoVo();
        vo.setSecret(secret);
        vo.setDisUserId(PinYinUtil.getFullSpell(userName));
        vo.setDisUserName(userName);
        vo.setDisModelId(memberInfo.getDisUserId());
        vo.setDisPlatSuper(memberInfo.getDisPlatSuper());
        vo.setDisNote("来源：plug测试");
        Gson gson=new Gson();
        DistResult result= sendToDistService.inviteUser(prefix,gson.toJson(vo));
        return result;
    }

    @RequestMapping("/tradeOrder")
    @ResponseBody
    public DistResult trade(String orderNumber,String amount, HttpServletRequest request){
        DisMemberInfo memberInfo= (DisMemberInfo) request.getSession().getAttribute("member");
        if(memberInfo==null){
            return DistResult.failure("请登录！");
        }

        DisProfitRecordVo vo = new DisProfitRecordVo();
        vo.setDisAmount(new BigDecimal(amount));
        vo.setOrderId(orderNumber);
        vo.setDisPlatformId(memberInfo.getDisPlatformId());
        vo.setDisSetUserId(memberInfo.getDisUserId());
        Gson gson=new Gson();
        DistResult result= sendToDistService.trade(prefix,gson.toJson(vo));
        return result;
    }

    @PostMapping("/subordinate")
    @ResponseBody
    public DistResult subordinate(HttpServletRequest request){
        DisMemberInfo memberInfo= (DisMemberInfo) request.getSession().getAttribute("member");
        if(memberInfo==null){
            return DistResult.failure("请登录！");
        }
        SubordinateReq req = new SubordinateReq();
        req.setMemberId(memberInfo.getDisUserId());
        Gson gson=new Gson();
        DistResult result= sendToDistService.subordinate(prefix,gson.toJson(req));
        return result;
    }
}
