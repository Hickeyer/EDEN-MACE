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
 * 交易金额记录表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_trade_record")
public class DisTradeRecord extends Model<DisTradeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * 第三方订单号
     */
	@TableField("trade_num")
	private String tradeNum;
    /**
     * 交易金额
     */
	@TableField("trade_amount")
	private BigDecimal tradeAmount;
    /**
     * 交易时间
     */
	@TableField("trade_time")
	private String tradeTime;


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

	public String getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisTradeRecord{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", tradeNum=" + tradeNum +
			", tradeAmount=" + tradeAmount +
			", tradeTime=" + tradeTime +
			"}";
	}
}
