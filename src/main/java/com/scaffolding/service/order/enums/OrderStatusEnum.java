package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 10:40 上午
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    WAIT_PAY        (1, "待支付"),
    WAIT_SEND       (2, "待发货"),
    WAIT_ACCEPT     (3, "待收货"),
    RECEIVED        (4, "已收货"),
    COMPLETED       (5, "已完成"),
    CLOSE_DEAL      (6, "已关闭"),


    ;

    private final Integer type;
    private final String typeName;

    public static OrderStatusEnum getEnumByType(Integer type) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getType().equals(type)) {
                return orderStatusEnum;
            }
        }
        return null;
    }

}
