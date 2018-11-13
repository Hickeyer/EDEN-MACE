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
 * @since 2018-10-18
 */
@TableName("sys_dic_type")
public class SysDicType extends Model<SysDicType> {

    private static final long serialVersionUID = 1L;

	@TableId(value="dic_type_id", type= IdType.AUTO)
	private Integer dicTypeId;
	@TableField("dic_type_name")
	private String dicTypeName;
	@TableField("dic_type_no")
	private String dicTypeNo;
	@TableField("dic_type_notes")
	private String dicTypeNotes;
	@TableField("dic_type_order")
	private Integer dicTypeOrder;
	@TableField("system_no")
	private String systemNo;
	@TableField("is_delete")
	private String isDelete;
	@TableField("add_time")
	private String addTime;
	@TableField("update_time")
	private String updateTime;


	public Integer getDicTypeId() {
		return dicTypeId;
	}

	public void setDicTypeId(Integer dicTypeId) {
		this.dicTypeId = dicTypeId;
	}

	public String getDicTypeName() {
		return dicTypeName;
	}

	public void setDicTypeName(String dicTypeName) {
		this.dicTypeName = dicTypeName;
	}

	public String getDicTypeNo() {
		return dicTypeNo;
	}

	public void setDicTypeNo(String dicTypeNo) {
		this.dicTypeNo = dicTypeNo;
	}

	public String getDicTypeNotes() {
		return dicTypeNotes;
	}

	public void setDicTypeNotes(String dicTypeNotes) {
		this.dicTypeNotes = dicTypeNotes;
	}

	public Integer getDicTypeOrder() {
		return dicTypeOrder;
	}

	public void setDicTypeOrder(Integer dicTypeOrder) {
		this.dicTypeOrder = dicTypeOrder;
	}

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
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
		return this.dicTypeId;
	}

	@Override
	public String toString() {
		return "SysDicType{" +
			"dicTypeId=" + dicTypeId +
			", dicTypeName=" + dicTypeName +
			", dicTypeNo=" + dicTypeNo +
			", dicTypeNotes=" + dicTypeNotes +
			", dicTypeOrder=" + dicTypeOrder +
			", systemNo=" + systemNo +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			"}";
	}
}
