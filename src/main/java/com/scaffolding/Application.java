package com.scaffolding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author yt
 */
@SpringBootApplication
@MapperScan(basePackages = "com.scaffolding.mapper")
@ServletComponentScan(value = {"com.scaffolding.config.filter"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}