package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.modular.dist.vo.DynamicVo;

import java.util.List;

/**
 * 记账表Service
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:44
 */
public interface IDisAmountSituationService {

    public List<DynamicVo> getDynamicInfo(String account);

}
