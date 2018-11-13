package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 发送短信信息表
 * </p>
 *
 * @author huangpu
 * @since 2018-04-05
 */
@TableName("mobile_message")
public class MobileMessage extends Model<MobileMessage> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String mobile;
	private String code;
	@TableField("send_time")
	private String sendTime;
	private Integer count;
	@TableField("add_time")
	private String addTime;
	@TableField("is_delete")
	private String isDelete;
	@TableField("update_time")
	private String updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MobileMessage{" +
			"id=" + id +
			", mobile=" + mobile +
			", code=" + code +
			", sendTime=" + sendTime +
			", count=" + count +
			", addTime=" + addTime +
			", isDelete=" + isDelete +
			", updateTime=" + updateTime +
			"}";
	}
}
