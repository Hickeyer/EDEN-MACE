package com.stylefeng.guns.modular.dist.amountsign;

import java.math.BigDecimal;

public interface AmountService {

    /**
     * @param userId
     * @param amount
     * @param sourceName
     * @param type
     */
    public void  addMoney(String userId, BigDecimal amount, String sourceName, String type);


    /**
     * 提现冻结金额
     * @param userId
     * @param amount
     */
    public void  frozenAmount(String userId, BigDecimal amount);


    /**
     * 最终处理
     * @param userId
     * @param amount
     */
    public  void reduceMoney(String userId, BigDecimal amount);

    /**
     * 退回冻结金额，可用金额
     * @param userId
     * @param amount
     */
    public  void returnMoney(String userId, BigDecimal amount);

}
