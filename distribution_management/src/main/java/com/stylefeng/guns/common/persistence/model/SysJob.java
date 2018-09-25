package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangpu
 * @since 2018-09-25
 */
@TableName("sys_job")
public class SysJob extends Model<SysJob>  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 任务名称
     */
	@TableField("job_name")
	private String jobName;
    /**
     * 任务组名
     */
	@TableField("job_group")
	private String jobGroup;
    /**
     * 时间表达式
     */
	@TableField("job_cron")
	private String jobCron;
    /**
     * 类路径,全类型
     */
	@TableField("job_class_path")
	private String jobClassPath;
    /**
     * 传递map参数
     */
	@TableField("job_data_map")
	private String jobDataMap;
    /**
     * 状态:1启用 0停用
     */
	@TableField("job_status")
	private Integer jobStatus;
    /**
     * 任务功能描述
     */
	@TableField("job_describe")
	private String jobDescribe;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobCron() {
		return jobCron;
	}

	public void setJobCron(String jobCron) {
		this.jobCron = jobCron;
	}

	public String getJobClassPath() {
		return jobClassPath;
	}

	public void setJobClassPath(String jobClassPath) {
		this.jobClassPath = jobClassPath;
	}

	public String getJobDataMap() {
		return jobDataMap;
	}

	public void setJobDataMap(String jobDataMap) {
		this.jobDataMap = jobDataMap;
	}

	public Integer getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobDescribe() {
		return jobDescribe;
	}

	public void setJobDescribe(String jobDescribe) {
		this.jobDescribe = jobDescribe;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysJob{" +
			"id=" + id +
			", jobName=" + jobName +
			", jobGroup=" + jobGroup +
			", jobCron=" + jobCron +
			", jobClassPath=" + jobClassPath +
			", jobDataMap=" + jobDataMap +
			", jobStatus=" + jobStatus +
			", jobDescribe=" + jobDescribe +
			"}";
	}
}
