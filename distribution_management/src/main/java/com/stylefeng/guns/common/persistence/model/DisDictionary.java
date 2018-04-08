package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author huangpu
 * @since 2018-04-05
 */
@TableName("dis_dictionary")
public class DisDictionary extends Model<DisDictionary> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 字典编码
     */
	@TableField("dis_code")
	private String disCode;
    /**
     * 字典隐藏字段
     */
	@TableField("dis_type")
	private String disType;
    /**
     * 字典值，为前台显示用
     */
	@TableField("dis_value")
	private String disValue;
    /**
     * 排序
     */
	@TableField("dis_sort")
	private Integer disSort;
	@TableField("dis_sys_id")
	private String disSysId;
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

	public String getDisCode() {
		return disCode;
	}

	public void setDisCode(String disCode) {
		this.disCode = disCode;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getDisValue() {
		return disValue;
	}

	public void setDisValue(String disValue) {
		this.disValue = disValue;
	}

	public Integer getDisSort() {
		return disSort;
	}

	public void setDisSort(Integer disSort) {
		this.disSort = disSort;
	}

	public String getDisSysId() {
		return disSysId;
	}

	public void setDisSysId(String disSysId) {
		this.disSysId = disSysId;
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
		return "DisDictionary{" +
			"id=" + id +
			", disCode=" + disCode +
			", disType=" + disType +
			", disValue=" + disValue +
			", disSort=" + disSort +
			", disSysId=" + disSysId +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
