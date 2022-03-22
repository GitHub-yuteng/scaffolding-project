package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/05/31/8:56
 * @Description: 订单列表Target所有枚举
 */
@Getter
@AllArgsConstructor
public enum OrderTargetEnum {

    /**
     * 订单
     */
    ALL                 (0, "全部",  1),
    WAIT_PAY            (1, "待支付",6),
    WAIT_DELIVERY       (2, "待发货",8),
    WAIT_RECEIVE        (5, "待收货",16),
    RECEIVED            (6, "已收货",18),
    COMPLETED           (7, "已完成",19),
    CLOSED              (9, "交易关闭",23),

    // 售后
    REFUND_AFTER   (51,"退款/售后",50),

    /**
     * 推广订单
     */
    ALL_STATUS          (100, "全部状态",1),
    WAIT_SETTLEMENT     (105, "待结算", 5),
    SETTLED             (110, "已结算", 10),
    INVALID             (115, "已失效", 15),


    ;

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型名称
     */
    private final String typeName;
    /**
     * 排序
     */
    private final Integer sort;

    public static OrderTargetEnum getEnumByTypeName(String typeName) {
        for (OrderTargetEnum orderTargetEnum : OrderTargetEnum.values()) {
            if (orderTargetEnum.getTypeName().equals(typeName)) {
                return orderTargetEnum;
            }
        }
        return null;
    }

    public static OrderTargetEnum getEnumByType(Integer type) {
        for (OrderTargetEnum orderTargetEnum : OrderTargetEnum.values()) {
            if (orderTargetEnum.getType().equals(type)) {
                return orderTargetEnum;
            }
        }
        return null;
    }
}
