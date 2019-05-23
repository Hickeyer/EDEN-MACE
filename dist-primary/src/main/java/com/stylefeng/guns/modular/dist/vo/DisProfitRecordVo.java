package com.stylefeng.guns.modular.dist.vo;

import java.math.BigDecimal;

/**
 * Created by huangpu on 2017/6/9.
 */
public class DisProfitRecordVo {

    //秘钥
    private String  secret;
    //发起人
    private String disSetUserId;

    //交易人金额
    private BigDecimal disAmount;

    //平台id
    private String disPlatformId;

    /**
     * 账户类型
     */
    private String accountType;

    //备注
    private String note;

    private  String orderId;

    private String upgradeLevel;

    //计算分润基础金额
    private BigDecimal baseAmount;


    private BigDecimal baseFixAmount;

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

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getBaseFixAmount() {
        return baseFixAmount;
    }

    public void setBaseFixAmount(BigDecimal baseFixAmount) {
        this.baseFixAmount = baseFixAmount;
    }
}
