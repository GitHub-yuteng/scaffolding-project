package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/05/06/18:50
 * @Description: 订单列表右上角lable枚举值
 */
@Getter
@AllArgsConstructor
public enum ConfirmWayEnum {

    /**
     * 下单方式
     */
    PRODUCT_CONFIRM    (1,"商详下单"),
    SHOPCART_CONFIRM   (2,"购物车下单"),
    ;

    private final Integer type;
    private final String typeName;

    public static ConfirmWayEnum getEnumByType(Integer type) {
        for (ConfirmWayEnum confirmWayEnum : ConfirmWayEnum.values()) {
            if (confirmWayEnum.getType().equals(type)) {
                return confirmWayEnum;
            }
        }
        return null;
    }
}
