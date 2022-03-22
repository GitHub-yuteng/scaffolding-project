package com.scaffolding.config.interceptor;

import com.scaffolding.auth.Authentication;
import com.scaffolding.auth.UserInfo;
import com.scaffolding.enums.UserTypeEnum;
import com.scaffolding.redis.RedisService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yt
 * @Description: 登录拦截器
 */
@Component
@Order(-80)
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    public static final String TOKEN = "token";

    /**
     * 该方法会在控制器方法前执行，中断后续操作。当其返回值为true时，表示继续向下执行；
     * 当其返回值为false时，会中断后续的所有操作（包括调用下一个拦截器和控制器类中的方法执行等）。
     * HttpServletResponse.SC_UNAUTHORIZED token过期401无权限
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String token = request.getHeader(TOKEN);
        //if (StringUtils.isBlank(token)) {
        //    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //    return false;
        //}

        //UserInfo cache = redisService.get(UserTokenKey.USER_TOKEN_KEY, token, UserInfo.class);
        //if (Objects.isNull(cache)) {
        //    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //    return false;
        //}
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setUsertype(UserTypeEnum.CONSUMER.getType());
        Authentication.setUserInfoThreadLocal(userInfo);
        //redisService.expire(UserTokenKey.USER_TOKEN_KEY, token);
        return true;
    }

    /**
     * 该方法会在控制器方法调用之后，且解析视图之前执行。可以通过此方法对请求域中的模型和视图做出进一步的修改。
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 该方法会在整个请求完成，即视图渲染结束之后执行。可以通过此方法实现一些资源清理、记录日志信息等工作。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {
        Authentication.remove();
    }
}
