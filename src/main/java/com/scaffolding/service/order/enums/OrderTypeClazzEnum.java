package com.scaffolding.service.order.enums;

import com.whhim.hxh.service.order.model.OrderService;
import com.whhim.hxh.service.order.model.impl.ConsumerPurchaseOrderService;
import com.whhim.hxh.service.order.model.impl.DistributorPurchaseOrderService;
import com.whhim.hxh.service.order.model.impl.ShareOrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:20
 * @Description: 订单模式策略实现枚举，请不要随意改动type值
 */
@Getter
@AllArgsConstructor
public enum OrderTypeClazzEnum {

    OREDR_SERVICE           (0, OrderService.class.getSimpleName()),
    /**
     * 消费者 自购订单 11 当出现自购新类型订单 12、13、14
     */
    CONSUMER_SELF_PURCHASE           (11, ConsumerPurchaseOrderService.class.getSimpleName()),
    /**
     * 分销员自购订单 12
     */
    DISTRIBUTOR_SELF_PURCHASE   (12, DistributorPurchaseOrderService.class.getSimpleName()),
    /**
     * 消费者推广分享购买 21 推广订单新类型 22、23、24
     */
    SHARE                   (21, ShareOrderService.class.getSimpleName())

    ;

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型名称
     */
    private final String typeName;

    public static OrderTypeClazzEnum getEnumByType(Integer type) {
        for (OrderTypeClazzEnum orderTypeClazzEnum : OrderTypeClazzEnum.values()) {
            if (orderTypeClazzEnum.getType().equals(type)) {
                return orderTypeClazzEnum;
            }
        }
        return null;
    }
}
