package com.scaffolding.config;

import com.whhim.hxh.config.interceptor.PlatformInterceptor;
import com.whhim.hxh.config.interceptor.RepeatSubmitInterceptor;
import com.whhim.hxh.config.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author whh-yt
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;
    @Autowired
    private PlatformInterceptor platformInterceptor;

    /**
     * 拦截路径列表
     */
    private final static List<String> TOKEN_INTERCEPTOR_LIST = new ArrayList<>();
    /**
     * 拦截路径白名单
     */
    private final static List<String> TOKEN_INTERCEPTOR_WHITE_LIST = new ArrayList<>();

    static {
        TOKEN_INTERCEPTOR_LIST.add("/api/**");
    }

    static {
        TOKEN_INTERCEPTOR_WHITE_LIST.add("");
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO 用户信息拦截
        registry.addInterceptor(tokenInterceptor).addPathPatterns(TOKEN_INTERCEPTOR_LIST).excludePathPatterns(TOKEN_INTERCEPTOR_WHITE_LIST);
        registry.addInterceptor(repeatSubmitInterceptor);
    }
}
