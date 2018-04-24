package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 代码类型表
 * </p>
 *
 * @author huangpu
 * @since 2018-02-24
 */
@TableName("sys_dic_type")
public class SysDicType extends Model<SysDicType> {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
	@TableId(value="dic_type_id", type= IdType.AUTO)
	private Integer dicTypeId;
    /**
     * 系统编码
     */
	@TableField("system_no")
	private String systemNo;
    /**
     * 类型编码
     */
	@TableField("dic_type_no")
	private String dicTypeNo;
    /**
     * 类型名称
     */
	@TableField("dic_type_name")
	private String dicTypeName;
    /**
     * 类型备注
     */
	@TableField("dic_type_notes")
	private String dicTypeNotes;
    /**
     * 类型序号
     */
	@TableField("dic_type_order")
	private Integer dicTypeOrder;
	private String creator;
	@TableField("creation_time")
	private Date creationTime;
	@TableField("modified_by")
	private String modifiedBy;
	@TableField("last_modify_time")
	private Date lastModifyTime;
	@TableField("last_modified_by")
	private String lastModifiedBy;


	public Integer getDicTypeId() {
		return dicTypeId;
	}

	public void setDicTypeId(Integer dicTypeId) {
		this.dicTypeId = dicTypeId;
	}

	public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}

	public String getDicTypeNo() {
		return dicTypeNo;
	}

	public void setDicTypeNo(String dicTypeNo) {
		this.dicTypeNo = dicTypeNo;
	}

	public String getDicTypeName() {
		return dicTypeName;
	}

	public void setDicTypeName(String dicTypeName) {
		this.dicTypeName = dicTypeName;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	protected Serializable pkVal() {
		return this.dicTypeId;
	}

	@Override
	public String toString() {
		return "SysDicType{" +
			"dicTypeId=" + dicTypeId +
			", systemNo=" + systemNo +
			", dicTypeNo=" + dicTypeNo +
			", dicTypeName=" + dicTypeName +
			", dicTypeNotes=" + dicTypeNotes +
			", dicTypeOrder=" + dicTypeOrder +
			", creator=" + creator +
			", creationTime=" + creationTime +
			", modifiedBy=" + modifiedBy +
			", lastModifyTime=" + lastModifyTime +
			", lastModifiedBy=" + lastModifiedBy +
			"}";
	}
}
