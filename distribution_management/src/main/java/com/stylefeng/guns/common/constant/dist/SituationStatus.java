package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  SituationStatus {
    INCOME_STATUS("0","收入"),
    PAY_STATUS("1","支出");
    private String status;
    private String mes;

    private static Map<String, SituationStatus> map = new HashMap<String, SituationStatus>();
    static {
        for (SituationStatus legEnum : SituationStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    SituationStatus(String status, String mes) {
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
