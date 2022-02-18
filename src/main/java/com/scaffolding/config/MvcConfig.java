package com.scaffolding.config;

import com.scaffolding.config.interceptor.RepeatSubmitInterceptor;
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
public class MvcConfig implements WebMvcConfigurer {

    private static final String[] REQUEST_INTERCEPTOR = {"/app"};

    @Autowired
    private RequestInterceptor requestInterceptor;
    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final String[] excludePathPatterns = {"/error","/files/**"};
        registry.addInterceptor(requestInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);

    }
}
