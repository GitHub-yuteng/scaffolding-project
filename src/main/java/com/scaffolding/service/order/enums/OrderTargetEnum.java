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
     *
     */
    ALL                 (0, "全部",1),
    WAIT_PAY            (1, "待支付",6),
    WAIT_DELIVERY       (2, "待发货",8),
    WAIT_SIGN           (3, "待签收",10),
    BEEN_DELIVERY       (4, "已发货",15),
    WAIT_RECEIVE        (5, "待收货",16),
    RECEIVED            (6, "已收货",18),
    COMPLETED           (7, "已完成",19),
    WAIT_EVALUATION     (9, "待评价",20),
    CLOSED              (10, "交易关闭",23),
    BEEN_CLOSED         (13, "已关闭",23),

    // cell 售后相关
    REFUND_AFTER_MINE   (51,"退款/售后",50),
    REFUND_AFTER_HOME   (52,"退款/售后",50),
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
