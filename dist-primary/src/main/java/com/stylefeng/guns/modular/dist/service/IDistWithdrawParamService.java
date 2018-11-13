package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DistWithdrawParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 提现参数设置Service
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:54:36
 */
public interface IDistWithdrawParamService {

    public List<Map<String, Object>> selectList();


    public void save(DistWithdrawParam param);

    public  void delete(Integer id);


    public  Map<String,Object> calAmount(BigDecimal amount);

}
