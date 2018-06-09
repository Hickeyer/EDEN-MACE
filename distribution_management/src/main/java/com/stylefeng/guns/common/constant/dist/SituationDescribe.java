package com.stylefeng.guns.common.constant.dist;

public enum  SituationDescribe {

    INCOME_STATUS_DES("0","%s的%s账户交易，根据当前费率，%s获得%s元，"),
    PAY_STATUS_DES("1","%s的%s账户提现"),
    AMOUNT_STATUS_INIT("2","账户初始化");
    private String status;
    private String mes;

    SituationDescribe(String status, String mes) {
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
