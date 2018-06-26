package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  IdentityStatus {

    USER_STATUS("0","用户"),
    PLAT_STATUS("1","平台");
    private String status;
    private String mes;

    private static Map<String, IdentityStatus> map = new HashMap<String, IdentityStatus>();
    static {
        for (IdentityStatus legEnum : IdentityStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    IdentityStatus(String status, String mes) {
        this.status=status;
        this.mes=mes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public static Map<String, IdentityStatus> getMap() {
        return map;
    }

    public static void setMap(Map<String, IdentityStatus> map) {
        IdentityStatus.map = map;
    }
}
