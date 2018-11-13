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
 * 账户变动表，用于记录账户变动情况
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_amount_situation")
public class DisAmountSituation extends Model<DisAmountSituation> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * (0:收入,1:支出)
     */
	private String type;
    /**
     * 总账户变动之前余额
     */
	@TableField("before_change_amount")
	private BigDecimal beforeChangeAmount;
    /**
     * 总账户变动之后余额
     */
	@TableField("after_change_amount")
	private BigDecimal afterChangeAmount;
    /**
     * 添加时间
     */
	@TableField("add_time")
	private String addTime;
    /**
     * 具体账户变动之前金额
     */
	@TableField("specific_before_change_amount")
	private BigDecimal specificBeforeChangeAmount;
    /**
     * 具体账户变动之后金额
     */
	@TableField("specific_after_change_amount")
	private BigDecimal specificAfterChangeAmount;
    /**
     * 具体账户类型
     */
	@TableField("account_type")
	private String accountType;
    /**
     * 账户变动金额
     */
	@TableField("change_amount")
	private BigDecimal changeAmount;
    /**
     * 具体变动描述
     */
	private String describe;


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getBeforeChangeAmount() {
		return beforeChangeAmount;
	}

	public void setBeforeChangeAmount(BigDecimal beforeChangeAmount) {
		this.beforeChangeAmount = beforeChangeAmount;
	}

	public BigDecimal getAfterChangeAmount() {
		return afterChangeAmount;
	}

	public void setAfterChangeAmount(BigDecimal afterChangeAmount) {
		this.afterChangeAmount = afterChangeAmount;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getSpecificBeforeChangeAmount() {
		return specificBeforeChangeAmount;
	}

	public void setSpecificBeforeChangeAmount(BigDecimal specificBeforeChangeAmount) {
		this.specificBeforeChangeAmount = specificBeforeChangeAmount;
	}

	public BigDecimal getSpecificAfterChangeAmount() {
		return specificAfterChangeAmount;
	}

	public void setSpecificAfterChangeAmount(BigDecimal specificAfterChangeAmount) {
		this.specificAfterChangeAmount = specificAfterChangeAmount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(BigDecimal changeAmount) {
		this.changeAmount = changeAmount;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisAmountSituation{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", type=" + type +
			", beforeChangeAmount=" + beforeChangeAmount +
			", afterChangeAmount=" + afterChangeAmount +
			", addTime=" + addTime +
			", specificBeforeChangeAmount=" + specificBeforeChangeAmount +
			", specificAfterChangeAmount=" + specificAfterChangeAmount +
			", accountType=" + accountType +
			", changeAmount=" + changeAmount +
			", describe=" + describe +
			"}";
	}
}
