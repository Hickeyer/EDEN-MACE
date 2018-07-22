package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  UserRankStatus {

    A_STATUS("A","青铜"),
    B_STATUS("B","黄金"),
    C_STATUS("C","铂金"),
    D_STATUS("D","钻石");
    private String status;
    private String mes;

    private static Map<String, UserRankStatus> map = new HashMap<String, UserRankStatus>();
    static {
        for (UserRankStatus legEnum : UserRankStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    UserRankStatus(String status, String mes) {
        this.status=status;
        this.mes=mes;
    }

    public static UserRankStatus getMethod(String symbol) {
        return map.get(symbol);
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
}
