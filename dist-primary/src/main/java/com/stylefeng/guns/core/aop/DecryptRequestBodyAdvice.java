package com.stylefeng.guns.core.aop;

import com.stylefeng.guns.common.annotion.OpenApiEncrypt;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.config.properties.EncryptProperties;
import com.stylefeng.guns.core.util.DESUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * @ClassName DecryptRequestBodyAdvice
 * @Description 请求解密
 * @Author zj
 * @Date 2020/4/8 13:14
 * @Company
 **/
//@ControllerAdvice(value="com.stylefeng.guns.modular.dist.controller")
public class DecryptRequestBodyAdvice implements RequestBodyAdvice {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EncryptProperties encryptProperties;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage
            httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {

        // 判断 是否是open api 请求
        if(methodParameter.hasMethodAnnotation(OpenApiEncrypt.class)){
            log.debug("对方法method :【" + methodParameter.getMethod().getName()
                    + "】请求数据进行解密");
            try {
               return new MyHttpInputMessage(httpInputMessage);
            }catch (Exception e){
                log.error("请求解密失败，请检查请求数据");
                throw new BussinessException(BizExceptionEnum.REQUEST_DECRYPT_ERROR);
            }
        }



        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage,
                                MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    class MyHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;

        private InputStream body;

        public MyHttpInputMessage(HttpInputMessage inputMessage)
                throws Exception {
            this.headers = inputMessage.getHeaders();
            this.body = IOUtils.toInputStream(
                    DESUtil.decrypt(IOUtils.toString(
                            inputMessage.getBody(), "UTF-8"),
                            encryptProperties.getKey()), "UTF-8");
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }
}
