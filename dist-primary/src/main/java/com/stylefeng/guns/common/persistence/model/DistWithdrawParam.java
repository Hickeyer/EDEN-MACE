package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 提现收费配置表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dist_withdraw_param")
public class DistWithdrawParam extends Model<DistWithdrawParam> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 开始金额
     */
	@TableField("begin_amount")
	private BigDecimal beginAmount;
    /**
     * 结束时间
     */
	@TableField("end_amount")
	private BigDecimal endAmount;
    /**
     * 计算模型，如 百分比和固定金额
     */
	@TableField("cal_model")
	private String calModel;
    /**
     * 提现值
     */
	@TableField("dis_withdraw_value")
	private String disWithdrawValue;
    /**
     * 是否删除
     */
	@TableField("is_delete")
	private String isDelete;
    /**
     * 添加时间
     */
	@TableField("add_time")
	private String addTime;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private String updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getBeginAmount() {
		return beginAmount;
	}

	public void setBeginAmount(BigDecimal beginAmount) {
		this.beginAmount = beginAmount;
	}

	public BigDecimal getEndAmount() {
		return endAmount;
	}

	public void setEndAmount(BigDecimal endAmount) {
		this.endAmount = endAmount;
	}

	public String getCalModel() {
		return calModel;
	}

	public void setCalModel(String calModel) {
		this.calModel = calModel;
	}

	public String getDisWithdrawValue() {
		return disWithdrawValue;
	}

	public void setDisWithdrawValue(String disWithdrawValue) {
		this.disWithdrawValue = disWithdrawValue;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
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
		return "DistWithdrawParam{" +
			"id=" + id +
			", beginAmount=" + beginAmount +
			", endAmount=" + endAmount +
			", calModel=" + calModel +
			", disWithdrawValue=" + disWithdrawValue +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
