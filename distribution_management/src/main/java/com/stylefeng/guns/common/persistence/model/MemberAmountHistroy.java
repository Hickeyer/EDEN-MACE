package com.stylefeng.guns.common.persistence.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户金额变化表
 * </p>
 *
 * @author huangpu
 * @since 2018-04-05
 */
@TableName("member_amount_histroy")
public class MemberAmountHistroy extends Model<MemberAmountHistroy> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 收入类型，支出或者收入
     */
	@TableField("his_type")
	private String hisType;
	@TableField("his_order")
	private String hisOrder;
	@TableField("his_amount")
	private BigDecimal hisAmount;
	@TableField("his_note")
	private String hisNote;
	@TableField("is_delete")
	private String isDelete;
	@TableField("add_time")
	private String addTime;
	@TableField("update_time")
	private String updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHisType() {
		return hisType;
	}

	public void setHisType(String hisType) {
		this.hisType = hisType;
	}

	public String getHisOrder() {
		return hisOrder;
	}

	public void setHisOrder(String hisOrder) {
		this.hisOrder = hisOrder;
	}

	public BigDecimal getHisAmount() {
		return hisAmount;
	}

	public void setHisAmount(BigDecimal hisAmount) {
		this.hisAmount = hisAmount;
	}

	public String getHisNote() {
		return hisNote;
	}

	public void setHisNote(String hisNote) {
		this.hisNote = hisNote;
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
		return "MemberAmountHistroy{" +
			"id=" + id +
			", hisType=" + hisType +
			", hisOrder=" + hisOrder +
			", hisAmount=" + hisAmount +
			", hisNote=" + hisNote +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
