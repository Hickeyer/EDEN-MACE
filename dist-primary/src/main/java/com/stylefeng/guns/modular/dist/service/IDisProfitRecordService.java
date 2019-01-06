package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;

import java.util.List;
import java.util.Map;

/**
 * 交易Service
 *
 * @author fengshuonan
 * @Date 2018-04-06 12:19:23
 */
public interface IDisProfitRecordService {

    List<Map<String, Object>> selectList(String account);

    public void save(DisProfitRecordVo param) throws Exception;

    public void generatorAllRecord(DisProfitRecordVo param,DisMemberInfo memberInfo);

}
