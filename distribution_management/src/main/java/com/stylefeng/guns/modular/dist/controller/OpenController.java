package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.tips.DistResult;
import com.stylefeng.guns.common.persistence.dao.DisMemberAmountMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统对外开放接口
 */
@Controller
public class OpenController  {

    @Autowired
    DisMemberInfoMapper disMemberInfoMapper;

    @Autowired
    DisMemberAmountMapper disMemberAmountMapper;

    @Value("${dist.jwt.isUse}")
    private  boolean jwtUse;



    @RequestMapping("/getUserInfo")
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    @ResponseBody
    public DistResult getUserInfo(String userId){
        if(jwtUse){
            System.out.println("开启验证");
        }
        DisMemberInfo memberInfoParam=new DisMemberInfo();
        memberInfoParam.setDisUserId(userId);
        DisMemberInfo  memberInfo=disMemberInfoMapper.selectOne(memberInfoParam);

        DisMemberAmount disMemberAmountParam=new DisMemberAmount();
        disMemberAmountParam.setDisUserId(userId);
        DisMemberAmount disMemberAmount=disMemberAmountMapper.selectOne(disMemberAmountParam);

        Map<String ,Object> map=new HashMap<>();
        if(memberInfo!=null){
            map.put("member",memberInfo);
            map.put("amount",disMemberAmount);
            DisMemberInfo sss= (DisMemberInfo) map.get("member");
            return DistResult.success(map);
        }else{
            return DistResult.failure("没有此用户");
        }

    }
}
