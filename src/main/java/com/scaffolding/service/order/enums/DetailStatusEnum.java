package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/05/26/20:32
 * @Description: 订单详情状态枚举
 */
@Getter
@AllArgsConstructor
public enum DetailStatusEnum {

    /**
     *
     */
    WAIT_PAYMENT        (0, "待支付",   ""),
    WAIT_DELIVERY       (1, "待发货",   ""),
    WAIT_SIGNED         (2, "待收货",   ""),
    RECEIVED            (3, "已收货",   ""),
    DELIVERY            (4, "平台已发货",""),
    PAY_OVERTIME        (5, "支付超时", ""),
    CANCEL              (6, "已取消",   ""),
    AFTER_SALE          (7, "售后中",   ""),
    SUCCESSFUL_DEAL     (8, "交易完成", ""),
    DEAL_CLOSE          (9, "交易关闭", ""),
    COMPLETED           (10,"已完成",  ""),
    CLOSED              (11,"已关闭",  ""),
    SUCCESS_AFTER_SALE  (12,"售后完成", ""),
    WAIT_RECEIVE_ORDER  (13,"待接单",  ""),
    DELIVERED           (14,"已发货",  ""),

    TAG_NOT_PAYING      (21,"未付款",  ""),

    ;

    private final Integer type;
    private final String typeName;
    private final String  iconUrl;


    public static DetailStatusEnum getEnumByType(Integer type) {
        for (DetailStatusEnum detailStatusEnum : DetailStatusEnum.values()) {
            if (detailStatusEnum.getType().equals(type)) {
                return detailStatusEnum;
            }
        }
        return null;
    }
}
