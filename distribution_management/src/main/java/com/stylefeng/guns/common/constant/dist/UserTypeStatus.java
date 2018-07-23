package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  UserTypeStatus {
    ZERO_STATUS("0","游客",0),
    ONE_STATUS("1","经理",1),
    TWO_STATUS("2","老板",2);
    private String status;
    private String mes;

    private int order;

    private static Map<String, UserTypeStatus> map = new HashMap<String, UserTypeStatus>();
    static {
        for (UserTypeStatus legEnum : UserTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    UserTypeStatus(String status, String mes,int order) {
        this.status=status;
        this.mes=mes;
        this.order=order;
    }

    public static UserTypeStatus getMethod(String symbol) {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
