package com.stylefeng.guns.modular.dist.vo;

public class Categories {

    private  String color;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{name: '"+name+"',itemStyle: {normal:{" +
                "color:'" + color + '\'' +
                '}'+'}'+'}';
    }
}
