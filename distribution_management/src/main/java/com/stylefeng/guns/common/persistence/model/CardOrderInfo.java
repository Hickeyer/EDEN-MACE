package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 办卡订单信息表
 * </p>
 *
 * @author huangpu
 * @since 2018-04-05
 */
@TableName("card_order_info")
public class CardOrderInfo extends Model<CardOrderInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("order_name")
	private String orderName;
	@TableField("order_id")
	private String orderId;
	@TableField("order_mobile")
	private String orderMobile;
	@TableField("order_idcardno")
	private String orderIdcardno;
	@TableField("order_email")
	private String orderEmail;
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

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderMobile() {
		return orderMobile;
	}

	public void setOrderMobile(String orderMobile) {
		this.orderMobile = orderMobile;
	}

	public String getOrderIdcardno() {
		return orderIdcardno;
	}

	public void setOrderIdcardno(String orderIdcardno) {
		this.orderIdcardno = orderIdcardno;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
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
		return "CardOrderInfo{" +
			"id=" + id +
			", orderName=" + orderName +
			", orderId=" + orderId +
			", orderMobile=" + orderMobile +
			", orderIdcardno=" + orderIdcardno +
			", orderEmail=" + orderEmail +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
