package com.rule.graph.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName XMLNode
 * @autor huangpu
 * @DATE 2020/7/14
 **/
public class XMLNode {

    private String id;

    private int deep;

    private PropertiesVO properties;

    private List<XMLNode> next = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<XMLNode> getNext() {
        return next;
    }

    public void setNext(List<XMLNode> next) {
        this.next = next;
    }

    public PropertiesVO getProperties() {
        return properties;
    }

    public void setProperties(PropertiesVO properties) {
        this.properties = properties;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public void addNext(XMLNode xmlNode){
        this.next.add(xmlNode);
    }
    public void addNextPost(int post,XMLNode xmlNode){
        this.next.add(post,xmlNode);
    }


    @Override
    public String toString() {
        return "XMLNode{" +
                "id='" + id + '\'' +
                ", deep='" + deep + '\'' +
                ", properties=" + properties +
                ", next=" + next +
                '}';
    }
}

    
    