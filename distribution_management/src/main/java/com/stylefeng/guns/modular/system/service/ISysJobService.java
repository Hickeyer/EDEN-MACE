package com.stylefeng.guns.modular.system.service;


import com.stylefeng.guns.common.persistence.model.SysJob;

import java.util.HashMap;
import java.util.List;

public interface ISysJobService {

	/**
	 * 获取任务数量
	 * @param
	 * @return
	 */
	public int getJobCount();

	/**
	 * 查询定时任务列表
	 * @param map
	 * @return
	 */
	List<SysJob> querySysJobList(HashMap<String, String> map);
	
	/**
	 * 新增定时任务
	 * @param record
	 * @return
	 */
    int insertSelective(SysJob record);

	/**
	 * 删除定时任务
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键查询定时任务详情
     * @param id
     * @return
     */
    SysJob selectByPrimaryKey(Integer id);
    
    /**
     * 根据bean查询定时任务详情
     * @param
     * @return
     */
    SysJob selectByBean(SysJob bean);
    
    /**
     * 更新定时任务详情
     * @param
     * @return
     */
    int updateByPrimaryKeySelective(SysJob bean);
}
