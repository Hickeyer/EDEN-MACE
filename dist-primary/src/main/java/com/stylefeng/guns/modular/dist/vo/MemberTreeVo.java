package com.stylefeng.guns.modular.dist.vo;

import java.util.List;

/**
 * @ClassName MemberTreeVo
 * @autor huangpu
 * @DATE 2019/5/21
 **/
public class MemberTreeVo {

    private String userId;

    private String name;

    private List<MemberTreeVo> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<MemberTreeVo> children) {
        this.children = children;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

    
    