package com.stylefeng.guns.common.constant.state;

/**
 * 数据库排序
 *
 * @author fengshuonan
 * @Date 2017年5月31日20:48:41
 */
public enum Order {

    /**
     * 正序
     */
    ASC("asc"),
    /**
     * 倒序
     */
    DESC("desc");

    private String des;

    Order(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
