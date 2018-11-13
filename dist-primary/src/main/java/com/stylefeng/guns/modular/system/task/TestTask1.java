package com.stylefeng.guns.modular.system.task;

import com.stylefeng.guns.core.util.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
public class TestTask1 implements BaseJob {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date) + " Task1： ----测试----");
    }
}
