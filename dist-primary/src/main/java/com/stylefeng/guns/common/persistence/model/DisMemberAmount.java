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
 * 账户金额表
 * </p>
 *
 * @author huangpu
 * @since 2019-01-06
 */
@TableName("dis_member_amount")
public class DisMemberAmount extends Model<DisMemberAmount> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户标示id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * 用户名称
     */
	@TableField("dis_user_name")
	private String disUserName;
    /**
     * 总金额
     */
	@TableField("total_amount")
	private BigDecimal totalAmount;
    /**
     * 冻结金额
     */
	@TableField("frozen_amount")
	private BigDecimal frozenAmount;
    /**
     * 可用金额
     */
	@TableField("avaible_amount")
	private BigDecimal avaibleAmount;
    /**
     * 类型（0会员 1 代理商）
     */
	private String type;
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
    /**
     * 状态（0正常 1冻结）
     */
	@TableField("amount_status")
	private String amountStatus;
    /**
     * 扩展字段，交易账户总金额
     */
	@TableField("trade_total_amount")
	private BigDecimal tradeTotalAmount;
    /**
     * 扩展字段，交易账户冻结金额
     */
	@TableField("trade_frozen_amount")
	private BigDecimal tradeFrozenAmount;
    /**
     * 扩展字段，交易账户可用金额
     */
	@TableField("trade_avaible_amount")
	private BigDecimal tradeAvaibleAmount;
    /**
     * 扩展字段，等级账户总金额
     */
	@TableField("level_total_amount")
	private BigDecimal levelTotalAmount;
    /**
     * 扩展字段，等级账户冻结金额
     */
	@TableField("level_frozen_amount")
	private BigDecimal levelFrozenAmount;
    /**
     * 扩展字段，等级账户可用金额
     */
	@TableField("level_avaible_amount")
	private BigDecimal levelAvaibleAmount;
    /**
     * 扩展字段，邀请用户总积分
     */
	@TableField("invite_total_amount")
	private BigDecimal inviteTotalAmount;
    /**
     * 扩展字段，邀请用户冻结积分
     */
	@TableField("invite_frozen_amount")
	private BigDecimal inviteFrozenAmount;
    /**
     * 扩展字段，邀请用户可用积分
     */
	@TableField("invite_avaible_amount")
	private BigDecimal inviteAvaibleAmount;


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

	public String getDisUserName() {
		return disUserName;
	}

	public void setDisUserName(String disUserName) {
		this.disUserName = disUserName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	public BigDecimal getAvaibleAmount() {
		return avaibleAmount;
	}

	public void setAvaibleAmount(BigDecimal avaibleAmount) {
		this.avaibleAmount = avaibleAmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getAmountStatus() {
		return amountStatus;
	}

	public void setAmountStatus(String amountStatus) {
		this.amountStatus = amountStatus;
	}

	public BigDecimal getTradeTotalAmount() {
		return tradeTotalAmount;
	}

	public void setTradeTotalAmount(BigDecimal tradeTotalAmount) {
		this.tradeTotalAmount = tradeTotalAmount;
	}

	public BigDecimal getTradeFrozenAmount() {
		return tradeFrozenAmount;
	}

	public void setTradeFrozenAmount(BigDecimal tradeFrozenAmount) {
		this.tradeFrozenAmount = tradeFrozenAmount;
	}

	public BigDecimal getTradeAvaibleAmount() {
		return tradeAvaibleAmount;
	}

	public void setTradeAvaibleAmount(BigDecimal tradeAvaibleAmount) {
		this.tradeAvaibleAmount = tradeAvaibleAmount;
	}

	public BigDecimal getLevelTotalAmount() {
		return levelTotalAmount;
	}

	public void setLevelTotalAmount(BigDecimal levelTotalAmount) {
		this.levelTotalAmount = levelTotalAmount;
	}

	public BigDecimal getLevelFrozenAmount() {
		return levelFrozenAmount;
	}

	public void setLevelFrozenAmount(BigDecimal levelFrozenAmount) {
		this.levelFrozenAmount = levelFrozenAmount;
	}

	public BigDecimal getLevelAvaibleAmount() {
		return levelAvaibleAmount;
	}

	public void setLevelAvaibleAmount(BigDecimal levelAvaibleAmount) {
		this.levelAvaibleAmount = levelAvaibleAmount;
	}

	public BigDecimal getInviteTotalAmount() {
		return inviteTotalAmount;
	}

	public void setInviteTotalAmount(BigDecimal inviteTotalAmount) {
		this.inviteTotalAmount = inviteTotalAmount;
	}

	public BigDecimal getInviteFrozenAmount() {
		return inviteFrozenAmount;
	}

	public void setInviteFrozenAmount(BigDecimal inviteFrozenAmount) {
		this.inviteFrozenAmount = inviteFrozenAmount;
	}

	public BigDecimal getInviteAvaibleAmount() {
		return inviteAvaibleAmount;
	}

	public void setInviteAvaibleAmount(BigDecimal inviteAvaibleAmount) {
		this.inviteAvaibleAmount = inviteAvaibleAmount;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisMemberAmount{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", disUserName=" + disUserName +
			", totalAmount=" + totalAmount +
			", frozenAmount=" + frozenAmount +
			", avaibleAmount=" + avaibleAmount +
			", type=" + type +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			", amountStatus=" + amountStatus +
			", tradeTotalAmount=" + tradeTotalAmount +
			", tradeFrozenAmount=" + tradeFrozenAmount +
			", tradeAvaibleAmount=" + tradeAvaibleAmount +
			", levelTotalAmount=" + levelTotalAmount +
			", levelFrozenAmount=" + levelFrozenAmount +
			", levelAvaibleAmount=" + levelAvaibleAmount +
			", inviteTotalAmount=" + inviteTotalAmount +
			", inviteFrozenAmount=" + inviteFrozenAmount +
			", inviteAvaibleAmount=" + inviteAvaibleAmount +
			"}";
	}
}
