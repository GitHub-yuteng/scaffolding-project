package com.scaffolding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yt
 * Spring Boot中大量使用了这些注解，常见的注解如下：
 * @ConditionalOnBean：当容器中有指定Bean的条件下进行实例化。
 * @ConditionalOnMissingBean：当容器里没有指定Bean的条件下进行实例化。
 * @ConditionalOnClass：当classpath类路径下有指定类的条件下进行实例化。
 * @ConditionalOnMissingClass：当类路径下没有指定类的条件下进行实例化。
 * @ConditionalOnWebApplication：当项目是一个Web项目时进行实例化。
 * @ConditionalOnNotWebApplication：当项目不是一个Web项目时进行实例化。
 * @ConditionalOnProperty：当指定的属性有指定的值时进行实例化。
 * @ConditionalOnExpression：基于SpEL表达式的条件判断。
 * @ConditionalOnJava：当JVM版本为指定的版本范围时触发实例化。
 * @ConditionalOnResource：当类路径下有指定的资源时触发实例化。
 * @ConditionalOnJndi：在JNDI存在的条件下触发实例化。
 * @ConditionalOnSingleCandidate：当指定的Bean在容器中只有一个，或者有多个但是指定了首选的Bean时触发实例化。
 */
@SpringBootApplication
@MapperScan(basePackages = "com.scaffolding.mapper")
@ComponentScan(basePackages = {"com.scaffolding.*"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}