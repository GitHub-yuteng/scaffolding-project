package com.scaffolding.init;

import com.scaffolding.wxpay.service.IHaXiaoHuiPayStrategy;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/17 4:20 下午
 */
@Component
public class ProjectInitRunner implements CommandLineRunner, ApplicationContextAware {

    private volatile ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        this.init();
    }

    public void init() {
        Collection<IHaXiaoHuiPayStrategy> payStrategyLinkedList = new LinkedList<>(this.applicationContext.getBeansOfType(IHaXiaoHuiPayStrategy.class).values());
        payStrategyLinkedList.forEach(System.out::println);
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
