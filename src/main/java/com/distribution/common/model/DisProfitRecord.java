package com.distribution.common.model;

import java.math.BigDecimal;

public class DisProfitRecord extends BaseModel {
    private Integer id;

    private String disGetUserId;

    private String disSetUserId;

    private BigDecimal disAmount;

    private String disProType;

    private String disNote;

    private String disOrderId;

    private String isDelete;

    private String addTime;

    private String updateTime;

    private String disUserType;

    public DisProfitRecord(String disGetUserId, String disSetUserId, BigDecimal disAmount, String disProType, String disNote, String disOrderId, String addTime,String disUserType) {
        this.disGetUserId = disGetUserId;
        this.disSetUserId = disSetUserId;
        this.disAmount = disAmount;
        this.disProType = disProType;
        this.disNote = disNote;
        this.disOrderId = disOrderId;
        this.addTime = addTime;
        this.disUserType=disUserType;
    }

    public DisProfitRecord(Integer id, String disGetUserId, String disSetUserId, BigDecimal disAmount, String disProType, String disNote, String disOrderId, String isDelete, String addTime, String updateTime) {
        this.id = id;
        this.disGetUserId = disGetUserId;
        this.disSetUserId = disSetUserId;
        this.disAmount = disAmount;
        this.disProType = disProType;
        this.disNote = disNote;
        this.disOrderId = disOrderId;
        this.isDelete = isDelete;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public String getDisUserType() {
        return disUserType;
    }

    public void setDisUserType(String disUserType) {
        this.disUserType = disUserType;
    }

    public DisProfitRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisGetUserId() {
        return disGetUserId;
    }

    public void setDisGetUserId(String disGetUserId) {
        this.disGetUserId = disGetUserId == null ? null : disGetUserId.trim();
    }

    public String getDisSetUserId() {
        return disSetUserId;
    }

    public void setDisSetUserId(String disSetUserId) {
        this.disSetUserId = disSetUserId == null ? null : disSetUserId.trim();
    }

    public BigDecimal getDisAmount() {
        return disAmount;
    }

    public void setDisAmount(BigDecimal disAmount) {
        this.disAmount = disAmount;
    }

    public String getDisProType() {
        return disProType;
    }

    public void setDisProType(String disProType) {
        this.disProType = disProType == null ? null : disProType.trim();
    }

    public String getDisNote() {
        return disNote;
    }

    public void setDisNote(String disNote) {
        this.disNote = disNote == null ? null : disNote.trim();
    }

    public String getDisOrderId() {
        return disOrderId;
    }

    public void setDisOrderId(String disOrderId) {
        this.disOrderId = disOrderId == null ? null : disOrderId.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}