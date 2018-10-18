package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author huangpu
 * @since 2018-10-18
 */
@TableName("sys_dic")
public class SysDic extends Model<SysDic> {

    private static final long serialVersionUID = 1L;

	@TableId(value="dic_id", type= IdType.AUTO)
	private Integer dicId;
	@TableField("dic_no")
	private String dicNo;
	@TableField("dic_notes")
	private String dicNotes;
	@TableField("dic_order")
	private Integer dicOrder;
	@TableField("dic_type_no")
	private String dicTypeNo;
	@TableField("dic_value")
	private String dicValue;
	@TableField("is_delete")
	private String isDelete;
	@TableField("add_time")
	private String addTime;
	@TableField("update_time")
	private String updateTime;
    /**
     * 扩展字段
     */
	@TableField("ext_field")
	private String extField;
    /**
     * 扩展字段2
     */
	@TableField("ext_field2")
	private String extField2;


	public Integer getDicId() {
		return dicId;
	}

	public void setDicId(Integer dicId) {
		this.dicId = dicId;
	}

	public String getDicNo() {
		return dicNo;
	}

	public void setDicNo(String dicNo) {
		this.dicNo = dicNo;
	}

	public String getDicNotes() {
		return dicNotes;
	}

	public void setDicNotes(String dicNotes) {
		this.dicNotes = dicNotes;
	}

	public Integer getDicOrder() {
		return dicOrder;
	}

	public void setDicOrder(Integer dicOrder) {
		this.dicOrder = dicOrder;
	}

	public String getDicTypeNo() {
		return dicTypeNo;
	}

	public void setDicTypeNo(String dicTypeNo) {
		this.dicTypeNo = dicTypeNo;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
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

	public String getExtField() {
		return extField;
	}

	public void setExtField(String extField) {
		this.extField = extField;
	}

	public String getExtField2() {
		return extField2;
	}

	public void setExtField2(String extField2) {
		this.extField2 = extField2;
	}

	@Override
	protected Serializable pkVal() {
		return this.dicId;
	}

	@Override
	public String toString() {
		return "SysDic{" +
			"dicId=" + dicId +
			", dicNo=" + dicNo +
			", dicNotes=" + dicNotes +
			", dicOrder=" + dicOrder +
			", dicTypeNo=" + dicTypeNo +
			", dicValue=" + dicValue +
			", isDelete=" + isDelete +
			", addTime=" + addTime +
			", updateTime=" + updateTime +
			", extField=" + extField +
			", extField2=" + extField2 +
			"}";
	}
}
