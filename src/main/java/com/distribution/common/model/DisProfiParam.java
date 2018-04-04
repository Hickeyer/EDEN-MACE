package com.distribution.common.model;

public class DisProfiParam extends  BaseModel {
    private Integer id;

    private String disPlatformId;

    private String disProMode;

    private String disProType;

    private String disProValue;

    private String disProLevel;

    private String disUserType;

    private String isDelete;

    private String updateTime;

    private String addTime;

    public DisProfiParam(Integer id, String disPlatformId, String disProMode, String disProType, String disProValue, String disProLevel, String disUserType, String addTime) {
        this.id = id;
        this.disPlatformId = disPlatformId;
        this.disProMode = disProMode;
        this.disProType = disProType;
        this.disProValue = disProValue;
        this.disProLevel = disProLevel;
        this.disUserType = disUserType;
        this.addTime = addTime;
    }

    public DisProfiParam(Integer id, String disPlatformId, String disProMode, String disProType, String disProValue, String disProLevel, String disUserType, String isDelete, String updateTime, String addTime) {
        this.id = id;
        this.disPlatformId = disPlatformId;
        this.disProMode = disProMode;
        this.disProType = disProType;
        this.disProValue = disProValue;
        this.disProLevel = disProLevel;
        this.disUserType = disUserType;
        this.isDelete = isDelete;
        this.updateTime = updateTime;
        this.addTime = addTime;
    }

    public DisProfiParam() {
        super();
    }

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
        this.disPlatformId = disPlatformId == null ? null : disPlatformId.trim();
    }

    public String getDisProMode() {
        return disProMode;
    }

    public void setDisProMode(String disProMode) {
        this.disProMode = disProMode == null ? null : disProMode.trim();
    }

    public String getDisProType() {
        return disProType;
    }

    public void setDisProType(String disProType) {
        this.disProType = disProType == null ? null : disProType.trim();
    }

    public String getDisProValue() {
        return disProValue;
    }

    public void setDisProValue(String disProValue) {
        this.disProValue = disProValue == null ? null : disProValue.trim();
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
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }
}