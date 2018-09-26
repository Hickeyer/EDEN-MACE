package com.stylefeng.guns.modular.dist.task;

import com.stylefeng.guns.core.util.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *积分任务调度
 * 规则：
 * 在当前时间下 所有的没有过期的 并且没有使用过的积分进行计算，给用户分配级别
 * 并且将对应的积分设置成已过期
 */
public class RankTask implements BaseJob {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }
}
