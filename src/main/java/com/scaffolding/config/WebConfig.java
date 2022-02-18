package com.scaffolding.config;

import com.scaffolding.config.interceptor.RepeatSubmitInterceptor;
import com.scaffolding.config.interceptor.PlatformWebRequestInterceptor;
import com.scaffolding.config.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author whh-yt
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RequestInterceptor requestInterceptor;
    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;
    @Autowired
    private PlatformWebRequestInterceptor platformWebRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor);
        registry.addInterceptor(repeatSubmitInterceptor);
        registry.addWebRequestInterceptor(platformWebRequestInterceptor);
    }
}
