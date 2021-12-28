package com.scaffolding.service.app.mine;

import com.scaffolding.service.order.model.IOrderModelStrategy;
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
public class RoleFactory {

    /**
     * 订单模式策略
     */
    private final static Map<String, IOrderModelStrategy> ORDER_MODEL_STRATEGY = new HashMap<>(16);

    /**
     * 将策略实现放入Spring容器管理 并且以工厂形式返回
     * @param modelStrategyList
     */
    public RoleFactory(List<IOrderModelStrategy> modelStrategyList) {
        for (IOrderModelStrategy modelStrategy : modelStrategyList) {
            Class<?> userClass = ClassUtils.getUserClass(modelStrategy.getClass());
            ORDER_MODEL_STRATEGY.put(userClass.getSimpleName(), modelStrategy);
        }
    }

    /**
     * 根据类名获取对应订单模式实现
     *
     * @param clazzName
     * @return
     */
    public IOrderModelStrategy getOrderModelStrategy(String clazzName) {
        return RoleFactory.ORDER_MODEL_STRATEGY.get(clazzName);
    }
}
