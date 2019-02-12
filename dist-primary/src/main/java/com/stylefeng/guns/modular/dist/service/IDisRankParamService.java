package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.DisRankParam;

import java.util.List;
import java.util.Map;

/**
 * 段位积分Service
 *
 * @author xiaojiang
 * @Date 2018-07-19 22:08:00
 */
public interface IDisRankParamService {


    public List<Map<String, Object>> selectList(String account,String calModel,String accountType,String disUserType,String disUserRank);

    public void save(DisRankParam param);

    public void delete(Integer id);

    public void update(DisRankParam param);

    public  DisRankParam  selectOne(Integer id);

}
