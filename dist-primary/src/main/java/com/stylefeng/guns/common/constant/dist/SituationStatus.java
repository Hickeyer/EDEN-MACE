package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  SituationStatus {
    /**
     * 收入
     */
    INCOME_STATUS("0","收入","%s的%s账户交易，根据当前费率，%s获得%s元，"),
    /**
     * 支出
     */
    PAY_STATUS("1","支出","%s的%s账户提现"),
    /**
     * 初始化状态
     */
    AMOUNT_INIT("2","初始化账户","账户初始化");
    private String status;
    private String mes;
    private String des;

    private static Map<String, SituationStatus> map = new HashMap<String, SituationStatus>();
    static {
        for (SituationStatus legEnum : SituationStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    SituationStatus(String status, String mes,String des) {
        this.status=status;
        this.mes=mes;
        this.des=des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
