package com.stylefeng.guns.modular.dist.vo;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Demo
 * @autor huangpu
 * @DATE 2019/5/21
 **/
public class Demo {

    public static void main(String[] args) {
        MemberTreeVo vo = new MemberTreeVo();
        List<MemberTreeVo> voList = new ArrayList<>();
        for (int i=0;i<10;i++){
            MemberTreeVo vo1 = new MemberTreeVo();
            vo1.setName("aa"+i);
            voList.add(vo1);
        }
        vo.setName("test");
        vo.setChildren(voList);
        Gson gson = new Gson();
        String result = gson.toJson(vo);
        System.out.println(result);
    }
}

    
    