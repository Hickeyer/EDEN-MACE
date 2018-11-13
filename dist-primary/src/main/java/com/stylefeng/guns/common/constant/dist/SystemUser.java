package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  SystemUser {

    /**
     * 平台
     */
    ADMIN_INFO("10000","admin");
    private String status;
    private String info;

    private static Map<String, AccountTypeStatus> map = new HashMap<String, AccountTypeStatus>();
    static {
        for (AccountTypeStatus legEnum : AccountTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    SystemUser(String status, String info) {
        this.status=status;
        this.info=info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
