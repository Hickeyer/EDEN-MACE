package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

/**
 *产品类型
 */
public enum AccountTypeStatus {

    /**
     * 交易分润
     */
    ZERO_STATUS("0","商品交易","trade","您的下级%s交易%s元,您获得%s积分",""),
    /**
     * 升级分润
     */
    ONE_STATUS("1","升级","level","您的下级%s升级,您获得%s积分",""),

    TWO_STATUS("2","邀请","invite","您的邀请下级%s,您获得%s积分","");
    //状态
    private String status;
    //描述
    private String mes;
    //编码
    private String code;

    //积分描述
    private String intDes;

    //现金描述
    private String amountDes;

    private static Map<String, AccountTypeStatus> map = new HashMap<String, AccountTypeStatus>();
    static {
        for (AccountTypeStatus legEnum : AccountTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    AccountTypeStatus(String status, String mes, String code,String intDes ,String amountDes) {
        this.status=status;
        this.mes=mes;
        this.code=code;
        this.intDes = intDes;
        this.amountDes =amountDes;
    }

    public static AccountTypeStatus getMethod(String symbol) {
        return map.get(symbol);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getIntDes() {
        return intDes;
    }

    public void setIntDes(String intDes) {
        this.intDes = intDes;
    }

    public String getAmountDes() {
        return amountDes;
    }

    public void setAmountDes(String amountDes) {
        this.amountDes = amountDes;
    }
}
