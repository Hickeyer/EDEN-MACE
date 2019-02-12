package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisUpgradeParamMapper;
import com.stylefeng.guns.common.persistence.model.DisUpgradeParam;
import com.stylefeng.guns.modular.dist.dao.DisUpgradeParamDao;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisUpgradeParamService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 垂直升级配置Dao
 *
 * @author xiaojiang
 * @Date 2018-07-23 16:07:11
 */
@Service
public class DisUpgradeParamServiceImpl implements IDisUpgradeParamService {

    @Resource
    DisUpgradeParamDao disUpgradeParamDao;

    @Resource
    DisUpgradeParamMapper disUpgradeParamMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String upgradeName) {
        return disUpgradeParamDao.selectList(upgradeName);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectAgentList(String upgradeName) {
        return disUpgradeParamDao.selectAgentList(upgradeName);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(DisUpgradeParam param) {
        param.setAddTime(DateUtils.getNowDateTime());
        disUpgradeParamMapper.insert(param);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void deleteById(Integer id) {
        disUpgradeParamMapper.deleteById(id);
    }

}
