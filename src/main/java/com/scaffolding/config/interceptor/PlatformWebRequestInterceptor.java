package com.scaffolding.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @Description: WebRequestInterceptor的入参WebRequest是包装了HttpServletRequest 和HttpServletResponse的，通过WebRequest获取Request中的信息更简便。
 * @Author whh-yt
 * @Date 2022/2/18 9:54 上午
 */
@Component
public class PlatformWebRequestInterceptor implements WebRequestInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        System.out.println(objectMapper.writeValueAsString(webRequest));
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
