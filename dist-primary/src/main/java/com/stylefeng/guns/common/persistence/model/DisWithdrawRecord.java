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
 * 提现表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_withdraw_record")
public class DisWithdrawRecord extends Model<DisWithdrawRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * 提现单号
     */
	@TableField("withdraw_num")
	private String withdrawNum;
    /**
     * 提现金额
     */
	@TableField("total_amount")
	private BigDecimal totalAmount;
    /**
     * 手续费
     */
	@TableField("fee_amount")
	private BigDecimal feeAmount;
    /**
     * 实际到账金额
     */
	@TableField("real_amount")
	private BigDecimal realAmount;
    /**
     * 提现时间
     */
	@TableField("withdraw_time")
	private String withdrawTime;
    /**
     * 处理时间
     */
	@TableField("handle_time")
	private String handleTime;
    /**
     * 处理状态
     */
	@TableField("withdraw_status")
	private String withdrawStatus;
    /**
     * 提现账户
     */
	@TableField("account_type")
	private String accountType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisUserId() {
		return disUserId;
	}

	public void setDisUserId(String disUserId) {
		this.disUserId = disUserId;
	}

	public String getWithdrawNum() {
		return withdrawNum;
	}

	public void setWithdrawNum(String withdrawNum) {
		this.withdrawNum = withdrawNum;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public String getWithdrawTime() {
		return withdrawTime;
	}

	public void setWithdrawTime(String withdrawTime) {
		this.withdrawTime = withdrawTime;
	}

	public String getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}

	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisWithdrawRecord{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", withdrawNum=" + withdrawNum +
			", totalAmount=" + totalAmount +
			", feeAmount=" + feeAmount +
			", realAmount=" + realAmount +
			", withdrawTime=" + withdrawTime +
			", handleTime=" + handleTime +
			", withdrawStatus=" + withdrawStatus +
			", accountType=" + accountType +
			"}";
	}
}
