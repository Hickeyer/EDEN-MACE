package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品分润模式
 */
public enum ProModelStatus {

    ZERO_STATUS("0","按照百分比计算"),
    ONE_STATUS("1","按照固定值结算");
    private String status;
    private String mes;

    private static Map<String, ProModelStatus> map = new HashMap<String, ProModelStatus>();
    static {
        for (ProModelStatus legEnum : ProModelStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    ProModelStatus(String status, String mes) {
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
