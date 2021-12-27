package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:20
 * @Description: 订单模式策略实现枚举，请不要随意改动type值
 */
@Getter
@AllArgsConstructor
public enum OrderModelClazzEnum {

    /**
     * 本地店铺 卖家/买家
     */
    LOCAL_TM_ORDER          (11, "LocalShopOrderService");

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型名称
     */
    private final String typeName;

    public static OrderModelClazzEnum getEnumByType(Integer type) {
        for (OrderModelClazzEnum orderModelClazzEnum : OrderModelClazzEnum.values()) {
            if (orderModelClazzEnum.getType().equals(type)) {
                return orderModelClazzEnum;
            }
        }
        return null;
    }
}
