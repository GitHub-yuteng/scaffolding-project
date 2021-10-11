package com.scaffolding.service.order;

import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yt
 * @Date: 2021/06/02/15:30
 * @Description: 订单模式工厂
 */
@Component
public class OrderModelFactory {

    /**
     * 订单模式策略
     */
    private final Map<String, IOrderModelStrategy> orderModelStrategy = new HashMap<>();

    public OrderModelFactory(List<IOrderModelStrategy> modelStrategyList) {
        for (IOrderModelStrategy modelStrategy : modelStrategyList) {
            Class<?> userClass = ClassUtils.getUserClass(modelStrategy.getClass());
            orderModelStrategy.put(userClass.getSimpleName(), modelStrategy);
        }
    }

    /**
     * 根据类名获取对应订单模式实现
     *
     * @param clazzName
     * @return
     */
    public IOrderModelStrategy getOrderModelStrategy(String clazzName) {
        return this.orderModelStrategy.get(clazzName);
    }
}
