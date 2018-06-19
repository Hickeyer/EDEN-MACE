package com.plug.xiaojiang.dist.common.constant;

import java.util.HashMap;
import java.util.Map;

public enum UserTypeStatus {
    ZERO_STATUS("0","游客"),
    ONE_STATUS("1","经理"),
    TWO_STATUS("2","老板");
    private String status;
    private String mes;

    private static Map<String, SituationStatus> map = new HashMap<String, SituationStatus>();
    static {
        for (SituationStatus legEnum : SituationStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    UserTypeStatus(String status, String mes) {
        this.status=status;
        this.mes=mes;
    }

    public static SituationStatus getMethod(String symbol) {
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
