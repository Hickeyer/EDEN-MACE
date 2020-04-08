package com.stylefeng.guns.core.aop;

import com.google.gson.Gson;
import com.stylefeng.guns.common.annotion.OpenApiEncrypt;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.config.properties.EncryptProperties;
import com.stylefeng.guns.core.util.DESUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName DecryptRequestBodyAdvice
 * @Description 响应加密
 * @Author zj
 * @Date 2020/4/8 13:14
 * @Company
 **/
@ControllerAdvice(value = "com.stylefeng.guns.modular.dist.controller",
        annotations = {RestController.class,Controller.class})
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EncryptProperties encryptProperties;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info(body.toString());
        if(methodParameter.hasMethodAnnotation(OpenApiEncrypt.class)){
            log.debug("对方法method :【" + methodParameter.getMethod().getName() +
                    "】返回数据进行加密");
            try{
                return DESUtil.encrypt(new Gson().toJson(body),encryptProperties
                        .getKey());
            }catch (Exception e){
                log.error("加密数据失败");
                throw new BussinessException(BizExceptionEnum.RESPONSE_ENCRYPT_ERROR);
            }
        }
        return body;
    }
}
