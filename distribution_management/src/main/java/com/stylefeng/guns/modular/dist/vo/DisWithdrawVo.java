package com.stylefeng.guns.modular.dist.vo;

import java.math.BigDecimal;

public class DisWithdrawVo {

    private String  secret;

    private String userId;

    private BigDecimal amount;

    /**
     * 提现账户
     */
    private String disProType;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDisProType() {
        return disProType;
    }

    public void setDisProType(String disProType) {
        this.disProType = disProType;
    }
}
