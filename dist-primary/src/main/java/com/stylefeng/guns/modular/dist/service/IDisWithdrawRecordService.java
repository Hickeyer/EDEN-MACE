package com.stylefeng.guns.modular.dist.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 提现记录Service
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:08
 */
public interface IDisWithdrawRecordService {


    public  void withdrawMoney(String userId, BigDecimal amount, String accountType);

    public List<Map<String, Object>> selectList(String account,String disUserId,String withdrawNum,String withdrawStatus,String accountType);

    public void dealWithdrawl(Integer id,String type);

}
