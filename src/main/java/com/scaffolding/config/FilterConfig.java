package com.scaffolding.config;

import com.scaffolding.config.filter.CrosFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

/**
 * @author whh-yt
 */
public class FilterConfig {

    @Autowired
    private CrosFilter crosFilter;

    @Bean
    public FilterRegistrationBean<CrosFilter> crosFilter() {
        FilterRegistrationBean<CrosFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(crosFilter);
        registration.addUrlPatterns("/*");
        registration.setName("crosFilter");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}