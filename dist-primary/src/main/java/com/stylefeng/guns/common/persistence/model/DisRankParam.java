package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 分润参数设置
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("dis_rank_param")
public class DisRankParam extends Model<DisRankParam> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 平台id
     */
	@TableField("dis_platform_id")
	private String disPlatformId;
    /**
     * 计算模型，如 百分比和固定金额
     */
	@TableField("cal_model")
	private String calModel;
    /**
     * 账户类型，如上级发展下级分润 ，交易分润。。。。
     */
	@TableField("account_type")
	private String accountType;
    /**
     * 积分值
     */
	@TableField("dis_integral_value")
	private String disIntegralValue;
    /**
     * 从下往上对应的级别关系
     */
	@TableField("dis_pro_level")
	private String disProLevel;
    /**
     * 会员类型（1000：平台标示，其他为用户类型）
     */
	@TableField("dis_user_type")
	private String disUserType;
    /**
     * 是否删除
     */
	@TableField("is_delete")
	private String isDelete;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private String updateTime;
    /**
     * 添加时间
     */
	@TableField("add_time")
	private String addTime;
    /**
     * 用户段位（青铜等）
     */
	@TableField("dis_user_rank")
	private String disUserRank;
    /**
     * 段位积分名称
     */
	@TableField("dis_rank_name")
	private String disRankName;


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

	public String getCalModel() {
		return calModel;
	}

	public void setCalModel(String calModel) {
		this.calModel = calModel;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDisIntegralValue() {
		return disIntegralValue;
	}

	public void setDisIntegralValue(String disIntegralValue) {
		this.disIntegralValue = disIntegralValue;
	}

	public String getDisProLevel() {
		return disProLevel;
	}

	public void setDisProLevel(String disProLevel) {
		this.disProLevel = disProLevel;
	}

	public String getDisUserType() {
		return disUserType;
	}

	public void setDisUserType(String disUserType) {
		this.disUserType = disUserType;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getDisUserRank() {
		return disUserRank;
	}

	public void setDisUserRank(String disUserRank) {
		this.disUserRank = disUserRank;
	}

	public String getDisRankName() {
		return disRankName;
	}

	public void setDisRankName(String disRankName) {
		this.disRankName = disRankName;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisRankParam{" +
			"id=" + id +
			", disPlatformId=" + disPlatformId +
			", calModel=" + calModel +
			", accountType=" + accountType +
			", disIntegralValue=" + disIntegralValue +
			", disProLevel=" + disProLevel +
			", disUserType=" + disUserType +
			", isDelete=" + isDelete +
			", updateTime=" + updateTime +
			", addTime=" + addTime +
			", disUserRank=" + disUserRank +
			", disRankName=" + disRankName +
			"}";
	}
}
