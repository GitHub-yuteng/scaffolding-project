package com.scaffolding.global.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author yt
 */
@Component
@Order(-80)
public class RequestInterceptor implements HandlerInterceptor {

    public static final String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration headerNames = request.getHeaderNames();
        String token = "";
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if (TOKEN.equals(key)) {
                token = request.getHeader(key);
            }
        }

        return true;
    }
}
