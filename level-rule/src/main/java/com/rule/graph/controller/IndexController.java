package com.rule.graph.controller;

import com.rule.graph.service.XmlParseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * @ClassName IndexController
 * @autor huangpu
 * @DATE 2020/7/9
 **/
@RestController
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    XmlParseService xmlParseService;

    @PostMapping("/test")
    public String test(String xml,String pageType) throws Exception {
//        logger.info("入参{}",xml);
        xmlParseService.doXMLParse(xml,pageType);
        return "sucess";
    }


    @GetMapping("/default")
    public String defaultXML() throws Exception {

        return xmlParseService.findProfitParamXML();
//        return XMlFileUtils.xml;
    }

    String xml="";


}

    
    