package com.plug.xiaojiang.dist.model;


import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author huangpu
 * @since 2019-02-02
 */
public class DisMemberInfo  {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Integer id;
    /**
     * 平台
     */
	private String disPlatformId;
    /**
     * 用户id
     */
	private String disUserId;
    /**
     * 上级id
     */
	private String disModelId;
    /**
     * 全路径
     */
	private String disFullIndex;
    /**
     * 用户名
     */
	private String disUserName;
    /**
     * 级别
     */
	private Integer disLevel;
    /**
     * 身份类型
     */
	private String disUserType;
    /**
     * 用户段位(青铜、黄金、白银等)
     */
	private String disUserRank;
    /**
     * 备注
     */
	private String disNote;
    /**
     * 添加时间
     */
	private String addTime;
    /**
     * 更新时间
     */
	private String updateTime;
    /**
     * 删除状态
     */
	private String isDelete;
    /**
     * 上级代理商id
     */
	private String disPlatSuper;
    /**
     * 代理商全路径
     */
	private String disPlatFullIndex;
    /**
     * 代理商等级
     */
	private Integer disPlatLevel;
    /**
     * 账户类型(0,会员，1：代理商)
     */
	private String type;
    /**
     * 段位积分
     */
	private Integer rankIntegral;
    /**
     * 段位总积分
     */
	private Integer totalRankIntegral;
    /**
     * 限制状态，0为正常，1为禁止邀请用户
     */
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
	public String toString() {
		return "DisMemberInfo{" +
				"id=" + id +
				", disPlatformId='" + disPlatformId + '\'' +
				", disUserId='" + disUserId + '\'' +
				", disModelId='" + disModelId + '\'' +
				", disFullIndex='" + disFullIndex + '\'' +
				", disUserName='" + disUserName + '\'' +
				", disLevel=" + disLevel +
				", disUserType='" + disUserType + '\'' +
				", disUserRank='" + disUserRank + '\'' +
				", disNote='" + disNote + '\'' +
				", addTime='" + addTime + '\'' +
				", updateTime='" + updateTime + '\'' +
				", isDelete='" + isDelete + '\'' +
				", disPlatSuper='" + disPlatSuper + '\'' +
				", disPlatFullIndex='" + disPlatFullIndex + '\'' +
				", disPlatLevel=" + disPlatLevel +
				", type='" + type + '\'' +
				", rankIntegral=" + rankIntegral +
				", totalRankIntegral=" + totalRankIntegral +
				", confineStatus=" + confineStatus +
				'}';
	}
}
