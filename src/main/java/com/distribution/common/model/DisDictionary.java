package com.distribution.common.model;

public class DisDictionary {
    private Integer id;

    private String disCode;

    private String disType;

    private String disValue;

    private Integer disSort;

    private String disSysId;

    private String isDelete;

    private String addTime;

    private String updateTime;

    public DisDictionary(Integer id, String disCode, String disType, String disValue, Integer disSort, String disSysId, String isDelete, String addTime, String updateTime) {
        this.id = id;
        this.disCode = disCode;
        this.disType = disType;
        this.disValue = disValue;
        this.disSort = disSort;
        this.disSysId = disSysId;
        this.isDelete = isDelete;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public DisDictionary() {
        super();
    }

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
        this.disCode = disCode == null ? null : disCode.trim();
    }

    public String getDisType() {
        return disType;
    }

    public void setDisType(String disType) {
        this.disType = disType == null ? null : disType.trim();
    }

    public String getDisValue() {
        return disValue;
    }

    public void setDisValue(String disValue) {
        this.disValue = disValue == null ? null : disValue.trim();
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
        this.disSysId = disSysId == null ? null : disSysId.trim();
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