package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户升级记录表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_upgrade_record")
public class DisUpgradeRecord extends Model<DisUpgradeRecord> {

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
     * 升级前等级
     */
	@TableField("before_upgrade_level")
	private String beforeUpgradeLevel;
    /**
     * 升级后等级
     */
	@TableField("after_upgrade_level")
	private String afterUpgradeLevel;
    /**
     * 等级差额
     */
	@TableField("level_differ")
	private String levelDiffer;
    /**
     * 升级时间
     */
	@TableField("upgrade_time")
	private String upgradeTime;
    /**
     * 升级类型(0:垂直升级 1：水平升级)
     */
	@TableField("level_type")
	private String levelType;


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

	public String getBeforeUpgradeLevel() {
		return beforeUpgradeLevel;
	}

	public void setBeforeUpgradeLevel(String beforeUpgradeLevel) {
		this.beforeUpgradeLevel = beforeUpgradeLevel;
	}

	public String getAfterUpgradeLevel() {
		return afterUpgradeLevel;
	}

	public void setAfterUpgradeLevel(String afterUpgradeLevel) {
		this.afterUpgradeLevel = afterUpgradeLevel;
	}

	public String getLevelDiffer() {
		return levelDiffer;
	}

	public void setLevelDiffer(String levelDiffer) {
		this.levelDiffer = levelDiffer;
	}

	public String getUpgradeTime() {
		return upgradeTime;
	}

	public void setUpgradeTime(String upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisUpgradeRecord{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", beforeUpgradeLevel=" + beforeUpgradeLevel +
			", afterUpgradeLevel=" + afterUpgradeLevel +
			", levelDiffer=" + levelDiffer +
			", upgradeTime=" + upgradeTime +
			", levelType=" + levelType +
			"}";
	}
}
