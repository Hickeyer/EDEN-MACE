package com.rule.graph.vo;

/**
 * @ClassName MxCellVO
 * @autor huangpu
 * @DATE 2020/7/10
 **/
public class MxCellVO {

    private  String id;

    private String parent;

    private String style;

    private String value;

    private String source;

    private String target;

    private String cellSign;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCellSign() {
        return cellSign;
    }

    public void setCellSign(String cellSign) {
        this.cellSign = cellSign;
    }

    @Override
    public String toString() {
        return "MxCellVO{" +
                "id='" + id + '\'' +
                ", parent='" + parent + '\'' +
                ", style='" + style + '\'' +
                ", value='" + value + '\'' +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", cellSign='" + cellSign + '\'' +
                '}';
    }
}

    
    