package com.scaffolding.service.order;

import com.whhim.hxh.service.order.model.IOrderStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yt
 * @Date: 2021/06/02/15:30
 * @Description: 订单模式策略
 */
@Component
public class OrderTypeFactory {

    /**
     * 订单模式策略
     */
    private final static Map<String, IOrderStrategy> ORDER_STRATEGY = new HashMap<>(16);

    /**
     * 将策略实现放入Spring容器管理 并且以工厂形式返回
     *
     * @param orderStrategyList
     */
    public OrderTypeFactory(List<IOrderStrategy> orderStrategyList) {
        for (IOrderStrategy orderStrategy : orderStrategyList) {
            Class<?> userClass = ClassUtils.getUserClass(orderStrategy.getClass());
            ORDER_STRATEGY.put(userClass.getSimpleName(), orderStrategy);
        }
    }

    /**
     * 根据类名获取对应订单模式实现
     *
     * @param clazzName
     * @return
     */
    public IOrderStrategy getOrderModelStrategy(String clazzName) {
        return OrderTypeFactory.ORDER_STRATEGY.get(clazzName);
    }
}
