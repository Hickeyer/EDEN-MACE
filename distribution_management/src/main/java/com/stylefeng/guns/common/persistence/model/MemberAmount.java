package com.stylefeng.guns.common.persistence.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用金额表
 * </p>
 *
 * @author huangpu
 * @since 2018-04-05
 */
@TableName("member_amount")
public class MemberAmount extends Model<MemberAmount> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("member_code")
	private String memberCode;
    /**
     * 账户类型
     */
	@TableField("member_type")
	private String memberType;
	@TableField("member_amount")
	private BigDecimal memberAmount;
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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public BigDecimal getMemberAmount() {
		return memberAmount;
	}

	public void setMemberAmount(BigDecimal memberAmount) {
		this.memberAmount = memberAmount;
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
		return "MemberAmount{" +
			"id=" + id +
			", memberCode=" + memberCode +
			", memberType=" + memberType +
			", memberAmount=" + memberAmount +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
