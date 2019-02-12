package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisRankParamMapper;
import com.stylefeng.guns.common.persistence.model.DisRankParam;
import com.stylefeng.guns.modular.dist.dao.DisRankParamDao;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisRankParamService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 段位积分Dao
 *
 * @author xiaojiang
 * @Date 2018-07-19 22:08:00
 */
@Service
public class DisRankParamServiceImpl implements IDisRankParamService {


    @Resource
    DisRankParamDao disRankParamDao;

    @Resource
    DisRankParamMapper disRankParamMapper;


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String account,String calModel,String accountType,String disUserType,String disUserRank) {
        List<Map<String, Object>> list = disRankParamDao.selectList(account,calModel, accountType, disUserType, disUserRank);
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(DisRankParam param) {
        param.setIsDelete("N");
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disRankParamMapper.insert(param);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void delete(Integer id) {
        disRankParamMapper.deleteById(id);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void update(DisRankParam param) {
        disRankParamMapper.updateById(param);
    }

    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public DisRankParam selectOne(Integer id) {
        DisRankParam param=new DisRankParam();
        param.setId(id);
        return disRankParamMapper.selectOne(param);
    }
}
