package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  ProTypeStatus {

    ZERO_STATUS("0","交易分润"),
    ONE_STATUS("1","上下级分润");
    private String status;
    private String mes;

    private static Map<String, ProTypeStatus> map = new HashMap<String, ProTypeStatus>();
    static {
        for (ProTypeStatus legEnum : ProTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    ProTypeStatus(String status, String mes) {
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


}
