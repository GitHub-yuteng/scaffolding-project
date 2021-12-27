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
public enum CornerLabelEnum {

    /**
     * 订单状态类型
     */
    ALL                     (-1,"全部"),
    WAIT_SEND               (1, "待发货"),
    WAIT_ACCEPT             (2, "待收货"),
    RECEIVED                (3, "已收货"),
    COMPLETED               (4, "已完成"),
    CLOSED                  (5, "已关闭"),
    WAIT_PAY                (6, "待支付"),
    WAIT_RECEIVE_ORDER      (7, "待接单"),
    PAY_OVER_TIME           (8, "支付超时"),
    SUCCESSFUL_DEAL         (9, "交易完成"),
    CLOSE_DEAL              (10,"交易关闭"),
    BEEN_DELIVERY           (12,"已发货"),
    PART_SEND               (15,"部分发货"),
    AFTER_SALESING          (21,"售后中"),
    AFTER_SALES_COMPLETE    (25,"售后完成"),
    ;

    private final Integer type;
    private final String typeName;

    public static CornerLabelEnum getEnumByTypeName(String typeName) {
        for (CornerLabelEnum cornerLabelEnum : CornerLabelEnum.values()) {
            if (cornerLabelEnum.getTypeName().equals(typeName)) {
                return cornerLabelEnum;
            }
        }
        return null;
    }

    public static CornerLabelEnum getEnumByType(Integer type) {
        for (CornerLabelEnum cornerLabelEnum : CornerLabelEnum.values()) {
            if (cornerLabelEnum.getType().equals(type)) {
                return cornerLabelEnum;
            }
        }
        return null;
    }
}
