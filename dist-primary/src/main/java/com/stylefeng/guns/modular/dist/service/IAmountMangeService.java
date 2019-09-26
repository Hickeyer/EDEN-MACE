package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.modular.dist.amountTemplate.AmountTemplateFactoryContext;

import java.math.BigDecimal;

public interface IAmountMangeService {


     void addMoney(String userId, BigDecimal amount, String sourceName, String type, String accountType);

      void frozenAmount(String userId, BigDecimal amount,String accountType);

      void reduceMoney(String userId, BigDecimal amount,String accountType);

      void returnMoney(String userId, BigDecimal amount,String accountType);

}
