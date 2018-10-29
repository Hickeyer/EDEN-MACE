package com.plug.xiaojiang.dist.model;


import java.math.BigDecimal;

/**
 * <p>
 * 账户金额表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
public class DisMemberAmount  {


	private Integer id;
    /**
     * 用户标示id
     */
	private String disUserId;
    /**
     * 用户名称
     */
	private String disUserName;
    /**
     * 总金额
     */
	private BigDecimal totalAmount;
    /**
     * 冻结金额
     */
	private BigDecimal frozenAmount;
    /**
     * 可用金额
     */
	private BigDecimal avaibleAmount;
    /**
     * 类型（0会员 1 代理商）
     */
	private String type;
    /**
     * 添加时间
     */
	private String addTime;
    /**
     * 修改时间
     */
	private String updateTime;
    /**
     * 状态（0正常 1冻结）
     */
	private String amountStatus;
    /**
     * 扩展字段，交易账户总金额
     */
	private BigDecimal tradeTotalAmount;
    /**
     * 扩展字段，交易账户冻结金额
     */
	private BigDecimal tradeFrozenAmount;
    /**
     * 扩展字段，交易账户可用金额
     */
	private BigDecimal tradeAvaibleAmount;
    /**
     * 扩展字段，等级账户总金额
     */
	private BigDecimal levelTotalAmount;
    /**
     * 扩展字段，等级账户冻结金额
     */
	private BigDecimal levelFrozenAmount;
    /**
     * 扩展字段，等级账户可用金额
     */
	private BigDecimal levelAvaibleAmount;


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
			"}";
	}
}
