package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/04/29/14:31
 * @Description: 订单金额列表枚举
 */
@Getter
@AllArgsConstructor
public enum OrderMoneyEnum {

    /**
     * 订单金额
     */
    ORDER_AMOUNT            (1, "商品金额", "", "￥",1),
    FREIGHT_AMOUNT          (2, "运费"   , "+",  "￥",5),
    ACTIVITY_AMOUNT         (3, "活动优惠", "-", "￥",10),
    COUPONS_AMOUNT          (5, "优惠券" ,  "-", "￥",20),
    TOTAL_DISCOUNT_AMOUNT   (6, "优惠总金额","-","￥",30),

    ;

    /**
     * 金额类型
     */
    private final Integer type;
    /**
     * 金额名称
     */
    private final String typeName;
    /**
     * 正负符号
     */
    private final String symbol;
    /**
     * 货币
     */
    private final String currency;
    /**
     * 排序
     */
    private final Integer sort;

    public static OrderMoneyEnum getEnumByTypeName(String typeName) {
        for (OrderMoneyEnum orderMoneyEnum : OrderMoneyEnum.values()) {
            if (orderMoneyEnum.getTypeName().equals(typeName)) {
                return orderMoneyEnum;
            }
        }
        return null;
    }

    public static OrderMoneyEnum getEnumByType(Integer type) {
        for (OrderMoneyEnum orderMoneyEnum : OrderMoneyEnum.values()) {
            if (orderMoneyEnum.getType().equals(type)) {
                return orderMoneyEnum;
            }
        }
        return null;
    }

}
