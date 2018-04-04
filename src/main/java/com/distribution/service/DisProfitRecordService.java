package com.distribution.service;

import com.distribution.common.model.DisProfitRecord;
import com.distribution.model.DisProfitRecordVo;

import java.util.List;

/**
 * Created by huangpu on 2017/6/9.
 */
public interface DisProfitRecordService {

    /**
     * 1、入参 交易人员 交易金额 交易类型 交易备注 交易第三方订单号
     * @param param
     */
    public void save(DisProfitRecordVo param);

    public List<DisProfitRecord> list(DisProfitRecord param);

}
