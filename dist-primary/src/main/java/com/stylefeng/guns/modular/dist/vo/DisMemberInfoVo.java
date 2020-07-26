package com.stylefeng.guns.modular.dist.vo;

public class DisMemberInfoVo   {

    private String  secret;

    private String disPlatformId;

    private String disUserId;

    private String disParentId;

    private String disUserName;

    private String disUserType;

    private String disNote;


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDisPlatformId() {
        return disPlatformId;
    }

    public void setDisPlatformId(String disPlatformId) {
        this.disPlatformId = disPlatformId;
    }

    public String getDisUserId() {
        return disUserId;
    }

    public void setDisUserId(String disUserId) {
        this.disUserId = disUserId;
    }

    public String getDisParentId() {
        return disParentId;
    }

    public void setDisParentId(String disParentId) {
        this.disParentId = disParentId;
    }



    public String getDisUserName() {
        return disUserName;
    }

    public void setDisUserName(String disUserName) {
        this.disUserName = disUserName;
    }

    public String getDisUserType() {
        return disUserType;
    }

    public void setDisUserType(String disUserType) {
        this.disUserType = disUserType;
    }

    public String getDisNote() {
        return disNote;
    }

    public void setDisNote(String disNote) {
        this.disNote = disNote;
    }

    @Override
    public String toString() {
        return "DisMemberInfoVo{" +
                "secret='" + secret + '\'' +
                ", disPlatformId='" + disPlatformId + '\'' +
                ", disUserId='" + disUserId + '\'' +
                ", disParentId='" + disParentId + '\'' +
                ", disUserName='" + disUserName + '\'' +
                ", disUserType='" + disUserType + '\'' +
                ", disNote='" + disNote + '\'' +
                '}';
    }
}