package com.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        System.out.println("检查是否登录"+user);
        if (user!=null){
            return true;
        }else {
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return  false;
        }
    }
}
