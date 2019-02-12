package com.stylefeng.guns.common.constant.dist;

/**
 * @ClassName ConfineStatus
 * @Version
 **/
public enum  ConfineStatus {

    NORMAL_STATUS(0,"正常状态"),
    ONE_STAUTS(1,"禁止邀请会员");

    private int status;

    private String name;

    ConfineStatus(int status,String name) {
        this.status = status;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

    
    