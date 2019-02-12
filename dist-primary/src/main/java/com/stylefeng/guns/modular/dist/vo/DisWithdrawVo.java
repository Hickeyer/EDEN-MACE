package com.stylefeng.guns.modular.dist.vo;

import java.math.BigDecimal;

public class DisWithdrawVo {

    private String  secret;

    private String userId;

    private BigDecimal amount;

    /**
     * 提现账户
     */
    private String accountType;

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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "DisWithdrawVo{" +
                "secret='" + secret + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
