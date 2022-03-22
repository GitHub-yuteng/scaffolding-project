package com.scaffolding.config.interceptor;

import com.whhim.hxh.enums.PlatformEnum;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author whh-yt
 * @Date 2022/2/18 9:54 上午
 * @Description: 拦截不同平台 处理不同流程
 * WebRequestInterceptor的入参WebRequest是包装了HttpServletRequest和HttpServletResponse的，通过WebRequest获取Request中的信息更简便。
 */
@Component
public class PlatformInterceptor implements HandlerInterceptor {

    private final static String SOURCE_WAY = "sourceWay";

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String sourceWay = request.getHeader(SOURCE_WAY);
        if (StringUtils.isBlank(sourceWay)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        PlatformEnum platformEnum = PlatformEnum.getEnumByType(sourceWay);
        switch (platformEnum) {
            case ANDROID:
                break;
            case IOS:
                break;
            case WECHAT:
                break;
            case WEB:
                break;
            default:
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return false;
        }
        return true;
    }
}
