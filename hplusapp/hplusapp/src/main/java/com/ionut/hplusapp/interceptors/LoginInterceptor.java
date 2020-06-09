package com.ionut.hplusapp.interceptors;

import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.*;

import javax.servlet.http.*;
import java.util.*;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get all cookies
        // get the session id
        // log the request path
        String sessionId = null;

        if (null != request.getCookies()) {
            for (Cookie cookie : request.getCookies()) {
                if ("JSESSIONID".equals(cookie.getName())){
                    sessionId = cookie.getValue();
                }
            }
        }
        System.out.println("Incoming request data log: session: " + sessionId +
                " at " + new Date() + " for " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("In post handle");
    }
}
