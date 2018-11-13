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
    ZERO_STATUS("0","交易分润","trade"),
    /**
     * 升级分润
     */
    ONE_STATUS("1","上下级分润","level");
    private String status;
    private String mes;

    private String code;


    private static Map<String, AccountTypeStatus> map = new HashMap<String, AccountTypeStatus>();
    static {
        for (AccountTypeStatus legEnum : AccountTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    AccountTypeStatus(String status, String mes, String code) {
        this.status=status;
        this.mes=mes;
        this.code=code;
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
}
