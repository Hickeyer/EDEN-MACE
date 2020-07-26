package com.stylefeng.guns.modular.dist.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.constant.dist.UserRankStatus;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.core.util.BaseJob;
import com.stylefeng.guns.core.util.SpringContextHolder;
import com.stylefeng.guns.modular.dist.service.ITaskService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 平台商调整
 *积分任务调度
 * 规则：
 * 在当前时间下 所有的没有过期的 并且没有使用过的积分进行计算，给用户分配级别
 * 并且将对应的积分设置成已过期
 */
public class AgentRankTask implements BaseJob {


    private Logger logger =  LoggerFactory.getLogger(AgentRankTask.class);

    ITaskService taskService;

    public AgentRankTask() {
        taskService = SpringContextHolder.getBean(ITaskService.class);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("开始更新平台商的水平等级");
        taskService.upgradeLevelVersionTwo(IdentityStatus.PLAT_STATUS.getStatus());
        logger.info("更新平台商的水平等级结束");
    }


}
