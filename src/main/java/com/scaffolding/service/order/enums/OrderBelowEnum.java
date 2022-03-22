package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/05/27/19:44
 * @Description: 订单底部信息枚举
 */
@Getter
@AllArgsConstructor
public enum OrderBelowEnum {

    /**
     * 底部
     */
    ORDER_NO       (1,"订单编号",  1,1),
    CREATE_TIME    (3,"下单时间",  0,2),
    PAY_TIME       (4,"支付时间",  0,3),
    DELIVERY_TIME  (5,"发货时间",  0,4),
    RECEIVE_TIME   (6,"收货时间",  0,5),
    FINISH_TIME    (7,"完成时间",  0,6),
    CANCEL_TIME    (9,"取消时间",  0,7),
    PAY_PATTERN    (11,"支付方式", 0,8),
    /**
     * 未支付/已支付
     */
    PAYMENT_STATUS (13,"支付状态",  0,9),
    CANCEL_MAN     (19,"取消人",   0,10),

    REFUND_REASON  (21,"退款原因",  0,11),
    REFUND_ORDER_NO(23,"退款编号",  0,12),
    APPLY_TIME     (25,"申请时间",  0,13),
    REFUND_TIME    (27,"退款时间",  0,14),
    NOTE           (31,"订单备注",  0,15),

    ;

    private final Integer type;
    private final String typeName;
    /**
     * 1: 复制
     */
    private final Integer action;
    private final Integer sort;


    public static OrderBelowEnum getEnumByTypeName(String typeName) {
        for (OrderBelowEnum orderBelowEnum : OrderBelowEnum.values()) {
            if (orderBelowEnum.getTypeName().equals(typeName)) {
                return orderBelowEnum;
            }
        }
        return null;
    }

    public static OrderBelowEnum getEnumByType(Integer type) {
        for (OrderBelowEnum orderBelowEnum : OrderBelowEnum.values()) {
            if (orderBelowEnum.getType().equals(type)) {
                return orderBelowEnum;
            }
        }
        return null;
    }
}
