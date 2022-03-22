package com.scaffolding.config.interceptor;

import com.whhim.hxh.aspect.RepeatSubmit;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.exception.RepeatSubmitException;
import com.whhim.hxh.redis.RedisService;
import com.whhim.hxh.redis.prefix.SubmitRepeatKey;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Description: 对一些标注 @RepeatSubmit 注解的接口进行重复请求限制
 * @Author whh-yt
 * @Date 2022/2/18 9:45 上午
 */
@Component
public class RepeatSubmitInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        // TODO 此拦截器要在 TokenInterceptor 之后注册，先要获取到用户信息
        UserInfo userInfo = Authentication.getUserInfo();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String simpleName = handlerMethod.getBeanType().getSimpleName();
        String methodName = handlerMethod.getMethod().getName();
        RepeatSubmit repeatSubmitAnnotation = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), RepeatSubmit.class);
        //只拦截标注了@RepeatSubmit该注解
        if (Objects.nonNull(repeatSubmitAnnotation)) {
            SubmitRepeatKey submitRepeatKey = new SubmitRepeatKey(simpleName + "-" + methodName, SubmitRepeatKey.EXPIRE_SECONDS);
            boolean repeat = redisService.setNx(submitRepeatKey, userInfo.getUserCode(), "1");
            if (!repeat) {
                throw new RepeatSubmitException(GlobalConstant.REPEAT_SUBMIT, simpleName + "-" + methodName + "-" + userInfo.getUserCode());
            }
        }
        return true;
    }
}
