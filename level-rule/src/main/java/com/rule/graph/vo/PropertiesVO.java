package com.rule.graph.vo;

/**
 * @ClassName PropertiesVO
 * @autor huangpu
 * @DATE 2020/7/10
 **/
public class PropertiesVO {

    private String id;

    // 交易账户
    private String accountType;

    private String calModel;

    private String disUserRank;

    private String disUserType;

    private String paramValue;

    private String plantFormId;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCalModel() {
        return calModel;
    }

    public void setCalModel(String calModel) {
        this.calModel = calModel;
    }

    public String getDisUserRank() {
        return disUserRank;
    }

    public void setDisUserRank(String disUserRank) {
        this.disUserRank = disUserRank;
    }

    public String getDisUserType() {
        return disUserType;
    }

    public void setDisUserType(String disUserType) {
        this.disUserType = disUserType;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getPlantFormId() {
        return plantFormId;
    }

    public void setPlantFormId(String plantFormId) {
        this.plantFormId = plantFormId;
    }

    @Override
    public String toString() {
        return "PropertiesVO{" +
                "id='" + id + '\'' +
                ", accountType='" + accountType + '\'' +
                ", calModel='" + calModel + '\'' +
                ", disUserRank='" + disUserRank + '\'' +
                ", disUserType='" + disUserType + '\'' +
                ", paramValue='" + paramValue + '\'' +
                ", plantFormId='" + plantFormId + '\'' +
                '}';
    }
}

    
    