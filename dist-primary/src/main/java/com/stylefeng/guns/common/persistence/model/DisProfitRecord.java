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
 * 分润记录表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_profit_record")
public class DisProfitRecord extends Model<DisProfitRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 收入编号
     */
	@TableField("profit_num")
	private String profitNum;
	@TableField("dis_platform_id")
	private String disPlatformId;
	@TableField("dis_get_user_id")
	private String disGetUserId;
	@TableField("dis_set_user_id")
	private String disSetUserId;
	@TableField("dis_amount")
	private BigDecimal disAmount;
    /**
     * 账户类型
     */
	@TableField("account_type")
	private String accountType;
    /**
     * 备注
     */
	@TableField("dis_note")
	private String disNote;
	@TableField("dis_user_type")
	private String disUserType;
    /**
     * 对应第三方订单编号
     */
	@TableField("dis_order_id")
	private String disOrderId;
	@TableField("is_delete")
	private String isDelete;
	@TableField("add_time")
	private String addTime;
	@TableField("update_time")
	private String updateTime;
    /**
     * 分类（0：用户分润 1:平台分润）
     */
	private String type;
    /**
     * 交易前金额
     */
	@TableField("before_amount")
	private BigDecimal beforeAmount;
    /**
     * 交易后金额
     */
	@TableField("after_amount")
	private BigDecimal afterAmount;
    /**
     * 交易类型交易前金额
     */
	@TableField("before_pro_amount")
	private BigDecimal beforeProAmount;
    /**
     * 交易类型交易后金额
     */
	@TableField("after_pro_amount")
	private BigDecimal afterProAmount;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfitNum() {
		return profitNum;
	}

	public void setProfitNum(String profitNum) {
		this.profitNum = profitNum;
	}

	public String getDisPlatformId() {
		return disPlatformId;
	}

	public void setDisPlatformId(String disPlatformId) {
		this.disPlatformId = disPlatformId;
	}

	public String getDisGetUserId() {
		return disGetUserId;
	}

	public void setDisGetUserId(String disGetUserId) {
		this.disGetUserId = disGetUserId;
	}

	public String getDisSetUserId() {
		return disSetUserId;
	}

	public void setDisSetUserId(String disSetUserId) {
		this.disSetUserId = disSetUserId;
	}

	public BigDecimal getDisAmount() {
		return disAmount;
	}

	public void setDisAmount(BigDecimal disAmount) {
		this.disAmount = disAmount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDisNote() {
		return disNote;
	}

	public void setDisNote(String disNote) {
		this.disNote = disNote;
	}

	public String getDisUserType() {
		return disUserType;
	}

	public void setDisUserType(String disUserType) {
		this.disUserType = disUserType;
	}

	public String getDisOrderId() {
		return disOrderId;
	}

	public void setDisOrderId(String disOrderId) {
		this.disOrderId = disOrderId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getBeforeAmount() {
		return beforeAmount;
	}

	public void setBeforeAmount(BigDecimal beforeAmount) {
		this.beforeAmount = beforeAmount;
	}

	public BigDecimal getAfterAmount() {
		return afterAmount;
	}

	public void setAfterAmount(BigDecimal afterAmount) {
		this.afterAmount = afterAmount;
	}

	public BigDecimal getBeforeProAmount() {
		return beforeProAmount;
	}

	public void setBeforeProAmount(BigDecimal beforeProAmount) {
		this.beforeProAmount = beforeProAmount;
	}

	public BigDecimal getAfterProAmount() {
		return afterProAmount;
	}

	public void setAfterProAmount(BigDecimal afterProAmount) {
		this.afterProAmount = afterProAmount;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisProfitRecord{" +
			"id=" + id +
			", profitNum=" + profitNum +
			", disPlatformId=" + disPlatformId +
			", disGetUserId=" + disGetUserId +
			", disSetUserId=" + disSetUserId +
			", disAmount=" + disAmount +
			", accountType=" + accountType +
			", disNote=" + disNote +
			", disUserType=" + disUserType +
			", disOrderId=" + disOrderId +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			", type=" + type +
			", beforeAmount=" + beforeAmount +
			", afterAmount=" + afterAmount +
			", beforeProAmount=" + beforeProAmount +
			", afterProAmount=" + afterProAmount +
			"}";
	}
}
