package com.scaffolding.config;

import com.scaffolding.config.filter.CrosFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;

/**
 * @author whh-yt
 */
public class FilterConfig {

    private CrosFilter crosFilter;

    public FilterRegistrationBean<CrosFilter> crosFilter() {
        FilterRegistrationBean<CrosFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(crosFilter);
        registration.addUrlPatterns("/*");
        registration.setName("crosFilter");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}