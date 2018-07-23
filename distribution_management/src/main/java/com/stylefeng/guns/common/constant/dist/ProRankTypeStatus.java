package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum ProRankTypeStatus {

    ZERO_STATUS("0","商品交易","您的下级%s交易%s元,您获得%s积分"),
    ONE_STATUS("1","升级","您的下级%s升级,您获得%s积分"),
    TWO_STATUS("2","邀请","您的邀请下级%s,您获得%s积分");
    private String status;
    private String mes;

    private String des;

    private static Map<String, ProRankTypeStatus> map = new HashMap<String, ProRankTypeStatus>();
    static {
        for (ProRankTypeStatus legEnum : ProRankTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    ProRankTypeStatus(String status, String mes,String des) {
        this.status=status;
        this.mes=mes;
        this.des=des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
