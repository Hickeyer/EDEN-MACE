package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统积分记录表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_rank_integral_record")
public class DisRankIntegralRecord extends Model<DisRankIntegralRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * 系统积分
     */
	@TableField("sys_integral")
	private Integer sysIntegral;
    /**
     * 是否使用（Y:使用,N未使用）
     */
	@TableField("is_use")
	private String isUse;
    /**
     * 是否过期(Y:已过期，N未过期) 暂时不用
     */
	@TableField("is_expire")
	private String isExpire;
    /**
     * 使用前积分
     */
	@TableField("before_integral")
	private Integer beforeIntegral;
    /**
     * 使用后积分
     */
	@TableField("after_integral")
	private Integer afterIntegral;
    /**
     * 到期时间（暂时不用）
     */
	@TableField("expire_time")
	private String expireTime;
    /**
     * 添加时间
     */
	@TableField("add_time")
	private String addTime;
    /**
     * 来源(交易、升级，下级升级)
     */
	@TableField("account_type")
	private String accountType;
    /**
     * 来源用户id
     */
	@TableField("source_user_id")
	private String sourceUserId;
    /**
     * 来源备注
     */
	@TableField("source_remak")
	private String sourceRemak;
    /**
     * 使用时间
     */
	@TableField("use_time")
	private String useTime;
    /**
     * 使用备注
     */
	@TableField("use_remark")
	private String useRemark;


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

	public Integer getSysIntegral() {
		return sysIntegral;
	}

	public void setSysIntegral(Integer sysIntegral) {
		this.sysIntegral = sysIntegral;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(String isExpire) {
		this.isExpire = isExpire;
	}

	public Integer getBeforeIntegral() {
		return beforeIntegral;
	}

	public void setBeforeIntegral(Integer beforeIntegral) {
		this.beforeIntegral = beforeIntegral;
	}

	public Integer getAfterIntegral() {
		return afterIntegral;
	}

	public void setAfterIntegral(Integer afterIntegral) {
		this.afterIntegral = afterIntegral;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public String getSourceRemak() {
		return sourceRemak;
	}

	public void setSourceRemak(String sourceRemak) {
		this.sourceRemak = sourceRemak;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getUseRemark() {
		return useRemark;
	}

	public void setUseRemark(String useRemark) {
		this.useRemark = useRemark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisRankIntegralRecord{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", sysIntegral=" + sysIntegral +
			", isUse=" + isUse +
			", isExpire=" + isExpire +
			", beforeIntegral=" + beforeIntegral +
			", afterIntegral=" + afterIntegral +
			", expireTime=" + expireTime +
			", addTime=" + addTime +
			", accountType=" + accountType +
			", sourceUserId=" + sourceUserId +
			", sourceRemak=" + sourceRemak +
			", useTime=" + useTime +
			", useRemark=" + useRemark +
			"}";
	}
}
