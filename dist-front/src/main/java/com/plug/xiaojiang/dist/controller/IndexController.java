package com.plug.xiaojiang.dist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.plug.xiaojiang.dist.common.tip.DistResult;
import com.plug.xiaojiang.dist.dto.DisMemberInfoVo;
import com.plug.xiaojiang.dist.dto.DisProfitRecordVo;
import com.plug.xiaojiang.dist.model.DisMemberAmount;
import com.plug.xiaojiang.dist.model.DisMemberInfo;
import com.plug.xiaojiang.dist.utils.PinYinUtil;
import com.plug.xiaojiang.dist.utils.http.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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



    @RequestMapping("/home")
    public String home(String userId, HttpServletRequest request){
        DisMemberInfo memberInfo= (DisMemberInfo) request.getSession().getAttribute("member");
        if(memberInfo!=null){
            return "/self";
        }
        DistResult result= RestClient.create(prefix+"/api/v1/getUserInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .addParam("userId",userId)
                .get(new ParameterizedTypeReference<DistResult>() {
                });
        if(result.isSuccess()){
            Map<String ,Object> map= (Map<String, Object>) result.getData();
            ObjectMapper  mapper=new ObjectMapper();
            DisMemberInfo member = mapper.convertValue(map.get("member"), DisMemberInfo.class);
            DisMemberAmount amount= mapper.convertValue(map.get("amount"),DisMemberAmount.class) ;
            request.getSession().setAttribute("member",member);
            request.getSession().setAttribute("amount",amount);
        }else{
            System.out.println("登录失败");
            return "/index";
        }
        return "/self";
    }
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
        DistResult result= RestClient.create(prefix+"/api/v1/memberAdd")
                .header("content-type", "text/xml,charset=utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .body(gson.toJson(vo))
                .post(new ParameterizedTypeReference<DistResult>() {
                });

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
        DistResult result= RestClient.create(prefix+"/api/v1/trade")
                .header("content-type", "text/xml,charset=utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .body(gson.toJson(vo))
                .post(new ParameterizedTypeReference<DistResult>() {
                });

        return result;
    }
}
