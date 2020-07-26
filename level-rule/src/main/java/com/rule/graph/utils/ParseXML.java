package com.rule.graph.utils;

import com.rule.graph.vo.MxCellVO;
import com.rule.graph.vo.PropertiesVO;
import com.rule.graph.vo.XMLNode;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ParseXML
 * @autor huangpu
 * @DATE 2020/7/10
 **/
public class ParseXML {



    public static void getCellList(Element node,List<MxCellVO> cellList) {
//        System.out.println("当前节点的名称：：" + node.getName());
        if("mxCell".equals(node.getName())){
            // 获取当前节点的所有属性节点
            List<Attribute> list = node.attributes();
            MxCellVO vo = new MxCellVO();
            // 遍历属性节点
            for (Attribute attr : list) {
                String name= attr.getName();
                String _value = attr.getValue();
                if("style".equals(name)){
                    if(_value.contains("startSign")){
                        vo.setCellSign("start");
                    }else if (_value.contains("taskSign")){
                        vo.setCellSign("task");
                    }else{
                        vo.setCellSign("");
                    }
                }
                if("id".equals(name)){
                    vo.setId(_value);
                }
                if("parent".equals(name)){
                    vo.setParent(_value);
                }


               if("style".equals(name)){
                    vo.setStyle(_value);
               }

                if("value".equals(name)){
                    vo.setValue(_value);
                }

                if("source".equals(name)){
                    vo.setSource(_value);
                }
                if("target".equals(name)){
                    vo.setTarget(_value);
                }


            }

            cellList.add(vo);
        }
        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            getCellList(e,cellList);
        }

    }
    public static void getObjectList(Element node,  Map<String,PropertiesVO> objectList) {

        if("object".equals(node.getName())){
            // 获取当前节点的所有属性节点
            List<Attribute> list = node.attributes();
            PropertiesVO vo = new PropertiesVO();
            // 遍历属性节点
            for (Attribute attr : list) {
                String name= attr.getName();
                String _value = attr.getValue();
                if("id".equals(name)){
                    vo.setId(_value);
                }
                if("calModel".equals(name)){
                    vo.setCalModel(_value);
                }
                if("disUserRank".equals(name)){
                    vo.setDisUserRank(_value);
                }


                if("disUserType".equals(name)){
                    vo.setDisUserType(_value);
                }

                if("paramValue".equals(name)){
                    vo.setParamValue(_value);
                }

                if("plantFormId".equals(name)){
                    vo.setPlantFormId(_value);
                }
                if("accountType".equals(name)){
                    vo.setAccountType(_value);
                }


            }
            objectList.put(vo.getId(),vo);
        }
        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            getObjectList(e,objectList);
        }

    }

    public static  void  generateNode(XMLNode xmlNode, Map<String,String> sourceTargetMap, Map<String,PropertiesVO> propertiesMap,String id,int deep){

        if(sourceTargetMap.get(id)==null){return;}
        String[] arr = sourceTargetMap.get(id).split(",");
        if(arr.length>0){
            for (int i =0;i<arr.length;i++){
                XMLNode childNode = new XMLNode();
                childNode.setId(arr[i]);
                childNode.setDeep(deep);
                childNode.setProperties(propertiesMap.get(arr[i]));
                xmlNode.addNextPost(i,childNode);
                int next_deep = deep+1;
                generateNode(xmlNode.getNext().get(i),sourceTargetMap,propertiesMap,arr[i],next_deep);
            }
        }
    }



    public void listNodes(Element node) {
        System.out.println("当前节点的名称：：" + node.getName());
        // 获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        // 遍历属性节点
        for (Attribute attr : list) {
            System.out.println(attr.getText() + "-----" + attr.getName() + "---" + attr.getValue());
        }

        if (!(node.getTextTrim().equals(""))) {
            System.out.println("文本内容：：：：" + node.getText());
        }

        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            listNodes(e);
        }
    }
    public void elementMethod(Element node) {
        System.err.println("开始执行elementMethod");
        // 获取node节点中，子节点的元素名称为supercars的元素节点。
        Element e = node.element("root");
        // 获取supercars元素节点中，子节点为carname的元素节点(可以看到只能获取第一个carname元素节点)
        Element carname = e.element("mxCell");

        System.out.println(e.getName() + "----" + carname.getText());


        /*// 获取supercars这个元素节点 中，所有子节点名称为carname元素的节点 。

        List<Element> carnames = e.elements("mxGeometry");*/
        for (Element cname : carname.elements()) {
            System.out.println(cname.getText());
        }

        // 获取supercars这个元素节点 所有元素的子节点。
        List<Element> elements = carname.elements();

        for (Element el : elements) {
            System.out.println(el.getText());
        }

    }
}

    
    