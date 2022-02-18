package com.scaffolding;

import com.scaffolding.global.bean.PcPlatformBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootInterceptApplicationTests {

    @Autowired(required = false)
    @Qualifier(value = "Win")
    private PcPlatformBean win;

    @Autowired(required = false)
    @Qualifier(value = "Linux")
    private PcPlatformBean linux;

    @Autowired(required = false)
    @Qualifier(value = "Mac")
    private PcPlatformBean mac;

    @Test
    void contextLoads() {
        System.out.println(win);
        System.out.println(linux);
        System.out.println(mac);
    }
}