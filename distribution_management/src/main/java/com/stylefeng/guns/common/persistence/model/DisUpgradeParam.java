package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 垂直升级配置表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_upgrade_param")
public class DisUpgradeParam extends Model<DisUpgradeParam> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 名称
     */
	@TableField("upgrade_name")
	private String upgradeName;
    /**
     * 开始金额
     */
	@TableField("begin_integral")
	private Integer beginIntegral;
    /**
     * 结束金额
     */
	@TableField("end_integral")
	private Integer endIntegral;
    /**
     * 用户水平等级
     */
	@TableField("dis_user_rank")
	private String disUserRank;
    /**
     * 是否删除
     */
	@TableField("is_delete")
	private String isDelete;
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
     * 0会员  1代理商
     */
	@TableField("identity_type")
	private String identityType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUpgradeName() {
		return upgradeName;
	}

	public void setUpgradeName(String upgradeName) {
		this.upgradeName = upgradeName;
	}

	public Integer getBeginIntegral() {
		return beginIntegral;
	}

	public void setBeginIntegral(Integer beginIntegral) {
		this.beginIntegral = beginIntegral;
	}

	public Integer getEndIntegral() {
		return endIntegral;
	}

	public void setEndIntegral(Integer endIntegral) {
		this.endIntegral = endIntegral;
	}

	public String getDisUserRank() {
		return disUserRank;
	}

	public void setDisUserRank(String disUserRank) {
		this.disUserRank = disUserRank;
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

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisUpgradeParam{" +
			"id=" + id +
			", upgradeName=" + upgradeName +
			", beginIntegral=" + beginIntegral +
			", endIntegral=" + endIntegral +
			", disUserRank=" + disUserRank +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			", identityType=" + identityType +
			"}";
	}
}
