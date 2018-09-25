package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.common.persistence.model.SysJob;
import com.stylefeng.guns.modular.system.dao.SysJobDao;
import com.stylefeng.guns.modular.system.service.ISysJobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class SysJobServiceImpl implements ISysJobService {

	@Resource
	private SysJobDao sysJobDao;

	@Override
	public int getJobCount() {
		return sysJobDao.getJobCount();
	}

	@Override
	public List<SysJob> querySysJobList(HashMap<String, String> map) {
		return sysJobDao.querySysJobList(map);
	}

	@Override
	public int insertSelective(SysJob record) {
		return sysJobDao.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysJobDao.deleteByPrimaryKey(id);
	}

	@Override
	public SysJob selectByPrimaryKey(Integer id) {
		return sysJobDao.selectByPrimaryKey(id);
	}

	@Override
	public SysJob selectByBean(SysJob bean) {
		return sysJobDao.selectByBean(bean);
	}

	@Override
	public int updateByPrimaryKeySelective(SysJob bean) {
		return sysJobDao.updateByPrimaryKeySelective(bean);
	}

}
