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
 * 代码表
 * </p>
 *
 * @author huangpu
 * @since 2018-02-24
 */
@TableName("sys_dic")
public class SysDic extends Model<SysDic> {

    private static final long serialVersionUID = 1L;

    /**
     * 代码ID
     */
	@TableId(value="dic_id", type= IdType.AUTO)
	private Integer dicId;
    /**
     * 代码类型编码
     */
	@TableField("dic_type_no")
	private String dicTypeNo;
    /**
     * 代码序号
     */
	@TableField("dic_order")
	private Integer dicOrder;
    /**
     * 代码编码
     */
	@TableField("dic_no")
	private String dicNo;
    /**
     * 代码值
     */
	@TableField("dic_value")
	private String dicValue;
    /**
     * 代码说明
     */
	@TableField("dic_notes")
	private String dicNotes;
	private String creator;
	@TableField("creation_time")
	private Date creationTime;
	@TableField("modified_by")
	private String modifiedBy;
	@TableField("last_modify_time")
	private Date lastModifyTime;
	@TableField("last_modified_by")
	private String lastModifiedBy;


	public Integer getDicId() {
		return dicId;
	}

	public void setDicId(Integer dicId) {
		this.dicId = dicId;
	}

	public String getDicTypeNo() {
		return dicTypeNo;
	}

	public void setDicTypeNo(String dicTypeNo) {
		this.dicTypeNo = dicTypeNo;
	}

	public Integer getDicOrder() {
		return dicOrder;
	}

	public void setDicOrder(Integer dicOrder) {
		this.dicOrder = dicOrder;
	}

	public String getDicNo() {
		return dicNo;
	}

	public void setDicNo(String dicNo) {
		this.dicNo = dicNo;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicNotes() {
		return dicNotes;
	}

	public void setDicNotes(String dicNotes) {
		this.dicNotes = dicNotes;
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
		return this.dicId;
	}

	@Override
	public String toString() {
		return "SysDic{" +
			"dicId=" + dicId +
			", dicTypeNo=" + dicTypeNo +
			", dicOrder=" + dicOrder +
			", dicNo=" + dicNo +
			", dicValue=" + dicValue +
			", dicNotes=" + dicNotes +
			", creator=" + creator +
			", creationTime=" + creationTime +
			", modifiedBy=" + modifiedBy +
			", lastModifyTime=" + lastModifyTime +
			", lastModifiedBy=" + lastModifiedBy +
			"}";
	}
}
