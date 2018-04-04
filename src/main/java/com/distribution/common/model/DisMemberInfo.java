package com.distribution.common.model;

public class DisMemberInfo extends BaseModel {
    private Integer id;

    private String disPlatformId;

    private String disUserId;

    private String disModelId;

    private String disFullIndex;

    private String disUserName;

    private Integer disLevel;

    private String disUserType;

    private String disNote;

    private String addTime;

    private String updateTime;

    private String isDelete;

    public DisMemberInfo(Integer id, String disPlatformId, String disUserId, String disModelId, String disFullIndex, String disUserName, Integer disLevel, String disUserType, String disNote, String addTime, String updateTime) {
        this.id = id;
        this.disPlatformId = disPlatformId;
        this.disUserId = disUserId;
        this.disModelId = disModelId;
        this.disFullIndex = disFullIndex;
        this.disUserName = disUserName;
        this.disLevel = disLevel;
        this.disUserType = disUserType;
        this.disNote = disNote;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public DisMemberInfo(Integer id, String disPlatformId, String disUserId, String disModelId, String disFullIndex, String disUserName, Integer disLevel, String disUserType, String disNote, String addTime, String updateTime, String isDelete) {
        this.id = id;
        this.disPlatformId = disPlatformId;
        this.disUserId = disUserId;
        this.disModelId = disModelId;
        this.disFullIndex = disFullIndex;
        this.disUserName = disUserName;
        this.disLevel = disLevel;
        this.disUserType = disUserType;
        this.disNote = disNote;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public DisMemberInfo() {
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

    public String getDisUserId() {
        return disUserId;
    }

    public void setDisUserId(String disUserId) {
        this.disUserId = disUserId == null ? null : disUserId.trim();
    }

    public String getDisModelId() {
        return disModelId;
    }

    public void setDisModelId(String disModelId) {
        this.disModelId = disModelId == null ? null : disModelId.trim();
    }

    public String getDisFullIndex() {
        return disFullIndex;
    }

    public void setDisFullIndex(String disFullIndex) {
        this.disFullIndex = disFullIndex == null ? null : disFullIndex.trim();
    }

    public String getDisUserName() {
        return disUserName;
    }

    public void setDisUserName(String disUserName) {
        this.disUserName = disUserName == null ? null : disUserName.trim();
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
        this.disUserType = disUserType == null ? null : disUserType.trim();
    }

    public String getDisNote() {
        return disNote;
    }

    public void setDisNote(String disNote) {
        this.disNote = disNote == null ? null : disNote.trim();
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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}