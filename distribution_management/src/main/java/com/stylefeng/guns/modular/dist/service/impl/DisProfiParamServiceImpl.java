package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisProfiParamMapper;
import com.stylefeng.guns.common.persistence.model.DisProfiParam;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisProfiParamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisProfiParamService;

import java.util.List;
import java.util.Map;

/**
 * 参数设置Dao
 *
 * @author huangpu
 * @Date 2018-04-06 11:33:32
 */
@Service
public class DisProfiParamServiceImpl implements IDisProfiParamService {


    @Autowired
    DisProfiParamDao disProfiParamDao;

    @Autowired
    DisProfiParamMapper disProfiParamMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList() {
        String account= ShiroKit.getUser().getAccount();
        List<Map<String, Object>> list=disProfiParamDao.selectList(account);
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(DisProfiParam param) {
        String account= ShiroKit.getUser().getAccount();
        param.setIsDelete("N");
        param.setDisPlatformId(account);
        disProfiParamMapper.insert(param);
    }
}
