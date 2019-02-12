package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author huangpu
 * @since 2019-02-02
 */
@TableName("dis_member_info")
public class DisMemberInfo extends Model<DisMemberInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 平台
     */
	@TableField("dis_platform_id")
	private String disPlatformId;
    /**
     * 用户id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * 上级id
     */
	@TableField("dis_model_id")
	private String disModelId;
    /**
     * 全路径
     */
	@TableField("dis_full_index")
	private String disFullIndex;
    /**
     * 用户名
     */
	@TableField("dis_user_name")
	private String disUserName;
    /**
     * 级别
     */
	@TableField("dis_level")
	private Integer disLevel;
    /**
     * 身份类型
     */
	@TableField("dis_user_type")
	private String disUserType;
    /**
     * 用户段位(青铜、黄金、白银等)
     */
	@TableField("dis_user_rank")
	private String disUserRank;
    /**
     * 备注
     */
	@TableField("dis_note")
	private String disNote;
    /**
     * 添加时间
     */
	@TableField("add_time")
	private String addTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private String updateTime;
    /**
     * 删除状态
     */
	@TableField("is_delete")
	private String isDelete;
    /**
     * 上级代理商id
     */
	@TableField("dis_plat_super")
	private String disPlatSuper;
    /**
     * 代理商全路径
     */
	@TableField("dis_plat_full_index")
	private String disPlatFullIndex;
    /**
     * 代理商等级
     */
	@TableField("dis_plat_level")
	private Integer disPlatLevel;
    /**
     * 账户类型(0,会员，1：代理商)
     */
	private String type;
    /**
     * 段位积分
     */
	@TableField("rank_integral")
	private Integer rankIntegral;
    /**
     * 段位总积分
     */
	@TableField("total_rank_integral")
	private Integer totalRankIntegral;
    /**
     * 限制状态，0为正常，1为禁止邀请用户
     */
	@TableField("confine_status")
	private Integer confineStatus;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisPlatformId() {
		return disPlatformId;
	}

	public void setDisPlatformId(String disPlatformId) {
		this.disPlatformId = disPlatformId;
	}

	public String getDisUserId() {
		return disUserId;
	}

	public void setDisUserId(String disUserId) {
		this.disUserId = disUserId;
	}

	public String getDisModelId() {
		return disModelId;
	}

	public void setDisModelId(String disModelId) {
		this.disModelId = disModelId;
	}

	public String getDisFullIndex() {
		return disFullIndex;
	}

	public void setDisFullIndex(String disFullIndex) {
		this.disFullIndex = disFullIndex;
	}

	public String getDisUserName() {
		return disUserName;
	}

	public void setDisUserName(String disUserName) {
		this.disUserName = disUserName;
	}

	public Integer getDisLevel() {
		return disLevel;
	}

	public void setDisLevel(Integer disLevel) {
		this.disLevel = disLevel;
	}

	public String getDisUserType() {
		return disUserType;
	}

	public void setDisUserType(String disUserType) {
		this.disUserType = disUserType;
	}

	public String getDisUserRank() {
		return disUserRank;
	}

	public void setDisUserRank(String disUserRank) {
		this.disUserRank = disUserRank;
	}

	public String getDisNote() {
		return disNote;
	}

	public void setDisNote(String disNote) {
		this.disNote = disNote;
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

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getDisPlatSuper() {
		return disPlatSuper;
	}

	public void setDisPlatSuper(String disPlatSuper) {
		this.disPlatSuper = disPlatSuper;
	}

	public String getDisPlatFullIndex() {
		return disPlatFullIndex;
	}

	public void setDisPlatFullIndex(String disPlatFullIndex) {
		this.disPlatFullIndex = disPlatFullIndex;
	}

	public Integer getDisPlatLevel() {
		return disPlatLevel;
	}

	public void setDisPlatLevel(Integer disPlatLevel) {
		this.disPlatLevel = disPlatLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRankIntegral() {
		return rankIntegral;
	}

	public void setRankIntegral(Integer rankIntegral) {
		this.rankIntegral = rankIntegral;
	}

	public Integer getTotalRankIntegral() {
		return totalRankIntegral;
	}

	public void setTotalRankIntegral(Integer totalRankIntegral) {
		this.totalRankIntegral = totalRankIntegral;
	}

	public Integer getConfineStatus() {
		return confineStatus;
	}

	public void setConfineStatus(Integer confineStatus) {
		this.confineStatus = confineStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisMemberInfo{" +
			"id=" + id +
			", disPlatformId=" + disPlatformId +
			", disUserId=" + disUserId +
			", disModelId=" + disModelId +
			", disFullIndex=" + disFullIndex +
			", disUserName=" + disUserName +
			", disLevel=" + disLevel +
			", disUserType=" + disUserType +
			", disUserRank=" + disUserRank +
			", disNote=" + disNote +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			", isDelete=" + isDelete +
			", disPlatSuper=" + disPlatSuper +
			", disPlatFullIndex=" + disPlatFullIndex +
			", disPlatLevel=" + disPlatLevel +
			", type=" + type +
			", rankIntegral=" + rankIntegral +
			", totalRankIntegral=" + totalRankIntegral +
			", confineStatus=" + confineStatus +
			"}";
	}
}
