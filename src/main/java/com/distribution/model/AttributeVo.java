package com.distribution.model;

/**
 * Created by huangpu on 2017/6/4.
 */
public class AttributeVo {

    private String width;

    private String height;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" +
                "width:'" + width + '\'' +
                ", height:'" + height + '\'' +
                '}';
    }
}
