package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.modular.dist.vo.TradeAmountVo;

import java.util.List;
import java.util.Map;

public interface IDisMemberAmountMongoService {

    public void save(String userId,String userName,String disPlatformId,String type);


    public List<Object> list(String param);


    List<Map<String, Object>> selectList();

    public void tradeAmount(TradeAmountVo tradeAmountVo);
}
