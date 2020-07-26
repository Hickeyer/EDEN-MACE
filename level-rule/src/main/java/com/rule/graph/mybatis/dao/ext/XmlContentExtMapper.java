package com.rule.graph.mybatis.dao.ext;

import com.rule.graph.mybatis.domain.XmlContent;

public interface XmlContentExtMapper {


    XmlContent selectByType(String type);

}