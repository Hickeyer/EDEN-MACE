package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

/**
 * 代理商级别
 */
public enum AgentRankStatus {

    /**
     * 普通代理商
     */
    A_STATUS("N1","普通代理商",1),
    /**
     * 中级代理商
     */
    B_STATUS("N2","中级代理商",2),
    /**
     * 高级代理商
     */
    C_STATUS("N3","高级代理商",3);
    private String status;
    private String mes;

    private int order;

    private static Map<String, AgentRankStatus> map = new HashMap<String, AgentRankStatus>();
    static {
        for (AgentRankStatus legEnum : AgentRankStatus.values()) {
            map.put(legEnum.getStatus(), legEnum);
        }
    }

    AgentRankStatus(String status, String mes, int order) {
        this.status=status;
        this.mes=mes;
        this.order=order;
    }

    public static AgentRankStatus getMethod(String symbol) {
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
