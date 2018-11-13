package com.stylefeng.guns.common.constant.dist;

import java.util.HashMap;
import java.util.Map;

public enum JurisdictionStatus {
    /**
     * 一级代理（平台商）对应的roleId
     */
    LEVEL_1_STATUS("1","5","一级代理（平台商）对应的roleId"),
    LEVEL_2_STATUS("2","7","二级代理对应的roleId"),
    LEVEL_3_STATUS("3","8","三级代理对应的roleId"),
    LEVEL_4_STATUS("4","9","四级代理对应的roleId"),
    LEVEL_5_STATUS("5","10","四级代理对应的roleId");
    private String level;
    private String roleId;
    private String des;

    private static Map<String, JurisdictionStatus> map = new HashMap<String, JurisdictionStatus>();
    static {
        for (JurisdictionStatus legEnum : JurisdictionStatus.values()) {
            map.put(legEnum.getLevel(), legEnum);
        }
    }

    JurisdictionStatus(String level, String roleId, String des) {
        this.level=level;
        this.roleId=roleId;
        this.des=des;
    }

    public static JurisdictionStatus getMethod(String level) {
        return map.get(level);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static Map<String, JurisdictionStatus> getMap() {
        return map;
    }

    public static void setMap(Map<String, JurisdictionStatus> map) {
        JurisdictionStatus.map = map;
    }
}
