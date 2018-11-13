package com.stylefeng.guns.common.constant.dist;

public enum JobStatus {

    /**
     * 启用
     */
    FIRST_STATUS("1","启用"),
    /**
     * 停用
     */
    SECOND_STATUS("2","停用");

    private String status;
    private String mes;

    JobStatus(String status, String mes) {
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
