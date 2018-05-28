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

    List<Map<String, Object>> selectList(String platformId);

    public void  addMoney(String userId, BigDecimal amount, String accountType);
}
