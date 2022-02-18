package com.scaffolding.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description: 继承WebMvcConfigurationSupport或WebMvcConfigurerAdapter类，重写addInterceptors，InterceptorRegistry实例就可以直接添加。
 *               顺便说下继承WebMvcConfigurationSupport或WebMvcConfigurerAdapter的区别，继承WebMvcConfigurationSupport不需要声明@EnableWebMvc注解，继承WebMvcConfigurerAdapter需要
 * @Author whh-yt
 * @Date 2022/2/18 10:04 上午
 */
@Component
public class PrintParamsInterceptor implements HandlerInterceptor {

}
