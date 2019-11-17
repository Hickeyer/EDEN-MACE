package com.plug.xiaojiang.dist.config;

import com.plug.xiaojiang.dist.model.DisMemberInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        DisMemberInfo memberInfo= (DisMemberInfo) request.getSession().getAttribute("member");
        if(memberInfo==null){
            String uri = request.getRequestURI();
            if("/".equals(uri)||"/index".equals(uri)||"/login".equals(uri)){
               return true;
            }else{
                if(uri.contains("login")){
                    return true;
                }
                response.sendRedirect(request.getContextPath()+"/index");
                return false;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
