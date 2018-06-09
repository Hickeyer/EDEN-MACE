package com.stylefeng.guns.common.constant.dist;

public enum  SituationStatus {
    INCOME_STATUS("0","收入"),
    PAY_STATUS("1","支出");
    private String status;
    private String mes;

    SituationStatus(String status, String mes) {
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
