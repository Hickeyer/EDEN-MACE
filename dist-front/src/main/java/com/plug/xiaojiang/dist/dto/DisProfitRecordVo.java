package com.plug.xiaojiang.dist.dto;

import java.math.BigDecimal;

/**
 * Created by huangpu on 2017/6/9.
 */
public class DisProfitRecordVo {

    private String  secret;

    private String disSetUserId;

    private BigDecimal disAmount;

    private String disPlatformId;

    /**
     * 账户类型
     */
    private String accountType;

    private String note;

    private  String orderId;

    private String upgradeLevel;

    public String getUpgradeLevel() {
        return upgradeLevel;
    }

    public void setUpgradeLevel(String upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDisSetUserId() {
        return disSetUserId;
    }

    public void setDisSetUserId(String disSetUserId) {
        this.disSetUserId = disSetUserId;
    }

    public BigDecimal getDisAmount() {
        return disAmount;
    }

    public void setDisAmount(BigDecimal disAmount) {
        this.disAmount = disAmount;
    }

    public String getDisPlatformId() {
        return disPlatformId;
    }

    public void setDisPlatformId(String disPlatformId) {
        this.disPlatformId = disPlatformId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
