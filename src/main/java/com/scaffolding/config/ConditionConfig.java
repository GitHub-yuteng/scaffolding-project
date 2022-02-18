package com.scaffolding.config;

import com.scaffolding.condition.LinuxCondition;
import com.scaffolding.condition.MacCondition;
import com.scaffolding.condition.WindowsCondition;
import com.scaffolding.global.bean.PcPlatformBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author whh-yt
 */
@Configuration
public class ConditionConfig {

    /**
     * 在Windows环境下注入的Bean为win
     *
     * @return
     */
    @Bean("Win")
    @Conditional(value = {WindowsCondition.class})
    public PcPlatformBean win() {
        return new PcPlatformBean("Win");
    }

    /**
     * 在Linux环境下注入的Bean为Linux
     *
     * @return
     */
    @Bean("Linux")
    @Conditional(value = {LinuxCondition.class})
    public PcPlatformBean linux() {
        return new PcPlatformBean("Linux");
    }

    /**
     * Mac
     *
     * @return
     */
    @Bean("Mac")
    @Conditional(value = {MacCondition.class})
    public PcPlatformBean mac() {
        return new PcPlatformBean("Mac");
    }
}