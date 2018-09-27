package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  SystemUser {

    ADMIN_INFO("10000","admin");
    private String status;
    private String info;

    private static Map<String, ProTypeStatus> map = new HashMap<String, ProTypeStatus>();
    static {
        for (ProTypeStatus legEnum : ProTypeStatus.values()) {
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
