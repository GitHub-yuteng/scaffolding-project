package com.scaffolding.service.order.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderButtonEnum {

    /**
     * 订单按钮枚举  排序值越小 越靠右显示（售后除外）
     */
    PAY_IMMEDIATELY         (11, "立即支付",10),
    MORE_ORDER              (12, "再来一单",35),
    CANCEL_ORDER            (13, "取消订单",40),
    CONFIRM_RECEIPT         (14, "确认收货",20),
    VIEW_LOGISTICS          (15, "查看物流",40),
    DELETE_ORDER            (16, "删除订单",1),

    /**
     * 50+ 售后相关
     */
    APPLY_REFUND            (51, "申请退款",51),
    AFTER_SALES_RECORDS     (52, "售后记录", 70),
    APPLICATION_CANCELED    (53, "撤销申请",101),


    ;

    private final Integer type;
    private final String typeName;
    private final Integer sort;


    public static OrderButtonEnum getEnumByTypeName(String typeName) {
        for (OrderButtonEnum orderButtonEnum : OrderButtonEnum.values()) {
            if (orderButtonEnum.getTypeName().equals(typeName)) {
                return orderButtonEnum;
            }
        }
        return null;
    }

    public static OrderButtonEnum getEnumByType(Integer type) {
        for (OrderButtonEnum orderButtonEnum : OrderButtonEnum.values()) {
            if (orderButtonEnum.getType().equals(type)) {
                return orderButtonEnum;
            }
        }
        return null;
    }
}
