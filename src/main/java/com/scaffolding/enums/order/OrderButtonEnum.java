package com.scaffolding.enums.order;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderButtonEnum {
    /**
     * 订单按钮枚举  排序值越小 越靠右显示
     */
    PAY_IMMEDIATELY         (0, "立即支付",10),
    ANOTHER_ORDER           (1, "再来一单",35),
    CANCEL_ORDER            (2, "取消订单",40),
    CONFIRM_RECEIPT         (3, "确认收货",20),
    APPLY_FOR_AFTER_SALES   (4, "批量售后",50),
    APPLICATION_CANCELED    (5, "撤销申请",101),
    CALL_SHOP               (6, "联系商家",1),
    CALL_CUSTOMER           (7, "联系客户",1),
    RECEIVE_PAYMENT_NOW     (8, "立即收款",1),
    AFTER_SALES_RECORDS     (9, "售后记录", 70),
    REFUSE_TO_SELL          (10, "拒绝售后",2),
    AGREE_TO_RETURN         (11, "同意售后",3),
    PICK_UP_SUCCESS         (12, "取货成功",1),
    PICK_UP_FAILED          (13, "取货失败",1),
    CONFIRM_STORAGE         (14, "确认入库",1),
    CONFIRM_REFUND          (15, "确认退款",2),
    RECEIVING_CODE          (16, "收货码", 36),
    VIEW_LOGISTICS          (17, "查看物流",21),
    RECEIVE_ORDER           (18, "接单",   1),
    REFUSED_ORDER           (19, "拒绝接单",1),
    DELIVERED               (20, "发货",   1),
    DELETE_ORDER            (21, "删除订单",1),
    CHECK_DETAILS           (22, "查看详情",1),
    EVALUATION              (23, "去评价", 1),
    EVALUATION_DETAIL       (24, "查看评价",1),
    CONTACT_KXW             (25, "联系客服",50),
    CALL_PHONE              (26, "拨打电话",51),
    APPLY_INVOICE           (27, "申请发票",80),
    CHECK_INVOICE           (28, "查看发票",80),
    BATCH_REFUND            (30, "一键退款",51),

    FILL_IN_THE_LOGISTICS   (50, "我已寄出 填写物流信息",1),
    APPLICATION_MODIFY      (51, "修改申请",2),
    CONFIRM_TO_SIGN         (52, "确认签收",2),
    REFUSE_TO_SIGN          (53, "拒绝签收",2),
    REFUSE_REFUND           (55, "拒绝退款",3),
    REFUSE_PICKUP           (56, "拒绝取件",1),
    AGREE_PICKUP            (57, "确认取件",3),
    CONTACT_SELLER          (59, "联系卖家",1),
    MAKE_A_CALL             (61, "拨打电话",2)


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
