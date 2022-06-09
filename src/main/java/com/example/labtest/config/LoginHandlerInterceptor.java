package com.example.labtest.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser=request.getSession().getAttribute("userid");
        if (loginUser==null){
            request.getRequestDispatcher("/login/user").forward(request,response);
            return false;
        }
        return true;
    }
}
