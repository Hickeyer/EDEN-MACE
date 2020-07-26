package com.rule.graph.mybatis.dao;

import com.rule.graph.mybatis.domain.XmlContent;

public interface XmlContentMapper {
    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(XmlContent record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(XmlContent record);

    /**
     *
     * @mbg.generated
     */
    XmlContent selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(XmlContent record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(XmlContent record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(XmlContent record);
}