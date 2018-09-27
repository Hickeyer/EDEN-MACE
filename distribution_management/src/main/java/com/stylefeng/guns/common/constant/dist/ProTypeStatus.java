package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

/**
 *产品类型
 */
public enum  ProTypeStatus {

    ZERO_STATUS("0","交易分润","trade"),
    ONE_STATUS("1","上下级分润","level");
    private String status;
    private String mes;

    private String code;


    private static Map<String, ProTypeStatus> map = new HashMap<String, ProTypeStatus>();
    static {
        for (ProTypeStatus legEnum : ProTypeStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    ProTypeStatus(String status, String mes,String code) {
        this.status=status;
        this.mes=mes;
        this.code=code;
    }

    public static ProTypeStatus getMethod(String symbol) {
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
