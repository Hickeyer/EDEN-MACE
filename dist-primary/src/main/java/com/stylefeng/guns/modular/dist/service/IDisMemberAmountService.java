package com.stylefeng.guns.modular.dist.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 账户管理Service
 *
 * @author xiaojiang
 * @Date 2018-05-08 21:16:47
 */
public interface IDisMemberAmountService {

    public void save(String userId,String userName,String type);

    List<Map<String, Object>> selectList(String platformId,String disUserId,String userType);

    public void  addMoney(String userId, BigDecimal amount, String accountType,String sourceName,String type);

    /**
     * 冻结金额
     * @param userId
     * @param amount
     * @param accountType
     */
    public void  frozenAmount(String userId, BigDecimal amount, String accountType);


    /**
     * 最终处理
     * @param userId
     * @param amount
     * @param accountType
     */
    public  void reduceMoney(String userId, BigDecimal amount, String accountType);

    /**
     * 退回冻结金额，可用金额
     * @param userId
     * @param amount
     * @param accountType
     */
    public  void returnMoney(String userId, BigDecimal amount, String accountType);

}
