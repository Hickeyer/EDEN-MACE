package com.stylefeng.guns.common.persistence.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 提现信息表
 * </p>
 *
 * @author huangpu
 * @since 2018-04-05
 */
@TableName("withdrawal_info")
public class WithdrawalInfo extends Model<WithdrawalInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("withdraw_num")
	private String withdrawNum;
	@TableField("withdraw_type")
	private String withdrawType;
	@TableField("withdraw_name")
	private String withdrawName;
	@TableField("withdraw_mobile")
	private String withdrawMobile;
	@TableField("withdraw_card")
	private String withdrawCard;
	@TableField("withdraw_amount")
	private BigDecimal withdrawAmount;
	@TableField("withdraw_poundage")
	private BigDecimal withdrawPoundage;
	@TableField("real_amount")
	private BigDecimal realAmount;
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

	public String getWithdrawNum() {
		return withdrawNum;
	}

	public void setWithdrawNum(String withdrawNum) {
		this.withdrawNum = withdrawNum;
	}

	public String getWithdrawType() {
		return withdrawType;
	}

	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}

	public String getWithdrawName() {
		return withdrawName;
	}

	public void setWithdrawName(String withdrawName) {
		this.withdrawName = withdrawName;
	}

	public String getWithdrawMobile() {
		return withdrawMobile;
	}

	public void setWithdrawMobile(String withdrawMobile) {
		this.withdrawMobile = withdrawMobile;
	}

	public String getWithdrawCard() {
		return withdrawCard;
	}

	public void setWithdrawCard(String withdrawCard) {
		this.withdrawCard = withdrawCard;
	}

	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public BigDecimal getWithdrawPoundage() {
		return withdrawPoundage;
	}

	public void setWithdrawPoundage(BigDecimal withdrawPoundage) {
		this.withdrawPoundage = withdrawPoundage;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
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
		return "WithdrawalInfo{" +
			"id=" + id +
			", withdrawNum=" + withdrawNum +
			", withdrawType=" + withdrawType +
			", withdrawName=" + withdrawName +
			", withdrawMobile=" + withdrawMobile +
			", withdrawCard=" + withdrawCard +
			", withdrawAmount=" + withdrawAmount +
			", withdrawPoundage=" + withdrawPoundage +
			", realAmount=" + realAmount +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
