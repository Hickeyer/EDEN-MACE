package com.rule.graph.mybatis.domain;

public class DisProfitParam {
    /**
     * 
     */
    private Integer id;

    /**
     * 平台id
     */
    private String disPlatformId;

    /**
     * 计算模型，如 百分比和固定金额
     */
    private String calModel;

    /**
     * 账户类型，如上级发展下级分润 ，交易分润。。。。
     */
    private String accountType;

    /**
     * 分润值
     */
    private String disProValue;

    /**
     * 从下往上对应的级别关系
     */
    private String disProLevel;

    /**
     * 会员类型（1000：平台标示，其他为用户类型）
     */
    private String disUserType;

    /**
     * 是否删除
     */
    private String isDelete;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 添加时间
     */
    private String addTime;

    /**
     * 交易方式(分润或者提现)
     */
    private String distTradeMode;

    /**
     * 用户段位（青铜等）
     */
    private String disUserRank;

    /**
     * 身份类型(0,会员，1：代理商)
     */
    private String identityType;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 平台id
     * @return dis_platform_id 平台id
     */
    public String getDisPlatformId() {
        return disPlatformId;
    }

    /**
     * 平台id
     * @param disPlatformId 平台id
     */
    public void setDisPlatformId(String disPlatformId) {
        this.disPlatformId = disPlatformId == null ? null : disPlatformId.trim();
    }

    /**
     * 计算模型，如 百分比和固定金额
     * @return cal_model 计算模型，如 百分比和固定金额
     */
    public String getCalModel() {
        return calModel;
    }

    /**
     * 计算模型，如 百分比和固定金额
     * @param calModel 计算模型，如 百分比和固定金额
     */
    public void setCalModel(String calModel) {
        this.calModel = calModel == null ? null : calModel.trim();
    }

    /**
     * 账户类型，如上级发展下级分润 ，交易分润。。。。
     * @return account_type 账户类型，如上级发展下级分润 ，交易分润。。。。
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 账户类型，如上级发展下级分润 ，交易分润。。。。
     * @param accountType 账户类型，如上级发展下级分润 ，交易分润。。。。
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * 分润值
     * @return dis_pro_value 分润值
     */
    public String getDisProValue() {
        return disProValue;
    }

    /**
     * 分润值
     * @param disProValue 分润值
     */
    public void setDisProValue(String disProValue) {
        this.disProValue = disProValue == null ? null : disProValue.trim();
    }

    /**
     * 从下往上对应的级别关系
     * @return dis_pro_level 从下往上对应的级别关系
     */
    public String getDisProLevel() {
        return disProLevel;
    }

    /**
     * 从下往上对应的级别关系
     * @param disProLevel 从下往上对应的级别关系
     */
    public void setDisProLevel(String disProLevel) {
        this.disProLevel = disProLevel == null ? null : disProLevel.trim();
    }

    /**
     * 会员类型（1000：平台标示，其他为用户类型）
     * @return dis_user_type 会员类型（1000：平台标示，其他为用户类型）
     */
    public String getDisUserType() {
        return disUserType;
    }

    /**
     * 会员类型（1000：平台标示，其他为用户类型）
     * @param disUserType 会员类型（1000：平台标示，其他为用户类型）
     */
    public void setDisUserType(String disUserType) {
        this.disUserType = disUserType == null ? null : disUserType.trim();
    }

    /**
     * 是否删除
     * @return is_delete 是否删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     * @param isDelete 是否删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * 添加时间
     * @return add_time 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * 添加时间
     * @param addTime 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    /**
     * 交易方式(分润或者提现)
     * @return dist_trade_mode 交易方式(分润或者提现)
     */
    public String getDistTradeMode() {
        return distTradeMode;
    }

    /**
     * 交易方式(分润或者提现)
     * @param distTradeMode 交易方式(分润或者提现)
     */
    public void setDistTradeMode(String distTradeMode) {
        this.distTradeMode = distTradeMode == null ? null : distTradeMode.trim();
    }

    /**
     * 用户段位（青铜等）
     * @return dis_user_rank 用户段位（青铜等）
     */
    public String getDisUserRank() {
        return disUserRank;
    }

    /**
     * 用户段位（青铜等）
     * @param disUserRank 用户段位（青铜等）
     */
    public void setDisUserRank(String disUserRank) {
        this.disUserRank = disUserRank == null ? null : disUserRank.trim();
    }

    /**
     * 身份类型(0,会员，1：代理商)
     * @return identity_type 身份类型(0,会员，1：代理商)
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * 身份类型(0,会员，1：代理商)
     * @param identityType 身份类型(0,会员，1：代理商)
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    @Override
    public String toString() {
        return "DisProfitParam{" +
                "id=" + id +
                ", disPlatformId='" + disPlatformId + '\'' +
                ", calModel='" + calModel + '\'' +
                ", accountType='" + accountType + '\'' +
                ", disProValue='" + disProValue + '\'' +
                ", disProLevel='" + disProLevel + '\'' +
                ", disUserType='" + disUserType + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", addTime='" + addTime + '\'' +
                ", distTradeMode='" + distTradeMode + '\'' +
                ", disUserRank='" + disUserRank + '\'' +
                ", identityType='" + identityType + '\'' +
                '}';
    }
}