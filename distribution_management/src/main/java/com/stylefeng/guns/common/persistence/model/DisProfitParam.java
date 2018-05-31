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
 * @since 2018-05-30
 */
@TableName("dis_profit_param")
public class DisProfitParam extends Model<DisProfitParam> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 平台id
     */
	@TableField("dis_platform_id")
	private String disPlatformId;
    /**
     * 分润模型，如 百分比和固定金额
     */
	@TableField("dis_pro_mode")
	private String disProMode;
    /**
     * 分润类别，如上级发展下级分润 ，交易分润。。。。
     */
	@TableField("dis_pro_type")
	private String disProType;
    /**
     * 分润值
     */
	@TableField("dis_pro_value")
	private String disProValue;
    /**
     * 从下往上对应的级别关系
     */
	@TableField("dis_pro_level")
	private String disProLevel;
    /**
     * 会员类型（0:代理商 1：会员）
     */
	@TableField("dis_user_type")
	private String disUserType;
	@TableField("is_delete")
	private String isDelete;
	@TableField("update_time")
	private String updateTime;
	@TableField("add_time")
	private String addTime;

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

	public String getDisProMode() {
		return disProMode;
	}

	public void setDisProMode(String disProMode) {
		this.disProMode = disProMode;
	}

	public String getDisProType() {
		return disProType;
	}

	public void setDisProType(String disProType) {
		this.disProType = disProType;
	}

	public String getDisProValue() {
		return disProValue;
	}

	public void setDisProValue(String disProValue) {
		this.disProValue = disProValue;
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


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisProfitParam{" +
			"id=" + id +
			", disPlatformId=" + disPlatformId +
			", disProMode=" + disProMode +
			", disProType=" + disProType +
			", disProValue=" + disProValue +
			", disProLevel=" + disProLevel +
			", disUserType=" + disUserType +
			", isDelete=" + isDelete +
			", updateTime=" + updateTime +
			", addTime=" + addTime +
			"}";
	}
}
