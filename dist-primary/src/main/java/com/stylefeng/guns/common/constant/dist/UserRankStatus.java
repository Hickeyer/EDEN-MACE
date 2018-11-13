package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum  UserRankStatus {

    /**
     * 青铜
     */
    A_STATUS("A","青铜",1),
    /**
     * 黄金
     */
    B_STATUS("B","黄金",2),
    /**
     * 铂金
     */
    C_STATUS("C","铂金",3),
    /**
     * 钻石
     */
    D_STATUS("D","钻石",4);
    private String status;
    private String mes;

    private int order;

    private static Map<String, UserRankStatus> map = new HashMap<String, UserRankStatus>();
    static {
        for (UserRankStatus legEnum : UserRankStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    UserRankStatus(String status, String mes,int order) {
        this.status=status;
        this.mes=mes;
        this.order=order;
    }

    public static UserRankStatus getMethod(String symbol) {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
