package com.stylefeng.guns.modular.dist.vo;

import java.math.BigDecimal;

/**
 * @author huangpu
 */
public class DisMemberAmountVo {

    private String disUserId;

    private String disUserName;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount;

    /**
     * 可用金额
     */
    private BigDecimal avaibleAmount;

    private String addTime;

    private String updateTime;

    //账户状态
    // 账户 0 正常 -1 暂时冻结 需要修改数据等 1 冻结
    private String amountStatus;

    private BigDecimal tradeAmount;

    //..... 很多金额

}
