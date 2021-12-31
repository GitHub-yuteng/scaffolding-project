package com.scaffolding.service.app.mine;

import com.scaffolding.service.app.mine.role.IMineRoleStrategy;
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
public class MineRoleFactory {

    /**
     * 订单模式策略
     */
    private final Map<String, IMineRoleStrategy> iRoleStrategyHashMap = new HashMap<>(16);

    /**
     * 将策略实现放入Spring容器管理 并且以工厂形式返回
     * @param mineRoleStrategieList
     */
    public MineRoleFactory(List<IMineRoleStrategy> mineRoleStrategieList) {
        for (IMineRoleStrategy iMineRoleStrategy : mineRoleStrategieList) {
            Class<?> userClass = ClassUtils.getUserClass(iMineRoleStrategy.getClass());
            iRoleStrategyHashMap.put(userClass.getSimpleName(), iMineRoleStrategy);
        }
    }

    /**
     * 根据类名获取对应订单模式实现
     *
     * @param clazzName
     * @return
     */
    public IMineRoleStrategy getMineRoleStrategy(String clazzName) {
        return iRoleStrategyHashMap.get(clazzName);
    }
}
