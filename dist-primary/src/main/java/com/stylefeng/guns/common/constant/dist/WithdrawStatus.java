package com.stylefeng.guns.common.constant.dist;

public enum WithdrawStatus {

    /**
     * 申请中
     */
    FIRST_STATUS("1","申请中"),
    /**
     * 审核成功
     */
    SECOND_STATUS("2","审核成功"),
    /**
     * 审核未通过
     */
    THIRD_STATUS("3","审核拒绝"),
    /**
     * 如果调用支付宝，或者其他的第三方接口需要 改成此状态
     */
    FORTH_STATUS("4","审核处理中");

    private String status;
    private String mes;

    WithdrawStatus(String status, String mes) {
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
