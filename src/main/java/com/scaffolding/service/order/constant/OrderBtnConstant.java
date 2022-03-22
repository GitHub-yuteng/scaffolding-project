package com.scaffolding.service.order.constant;


import com.scaffolding.controller.order.vo.OrderButtonVO;
import com.scaffolding.service.order.enums.OrderButtonEnum;

/**
 * @Author: yt
 * @Date: 2021/04/18/15:28
 * @Description:
 */
public interface OrderBtnConstant {

    /**
     * 立即支付
     */
    OrderButtonVO PAY_IMMEDIATELY = new OrderButtonVO(OrderButtonEnum.PAY_IMMEDIATELY.getType(), OrderButtonEnum.PAY_IMMEDIATELY.getTypeName(), 0, OrderButtonEnum.PAY_IMMEDIATELY.getSort());
    /**
     * 再来一单
     */
    OrderButtonVO MORE_ORDER    = new OrderButtonVO(OrderButtonEnum.MORE_ORDER.getType(), OrderButtonEnum.MORE_ORDER.getTypeName(), 0, OrderButtonEnum.MORE_ORDER.getSort());
    /**
     * 取消订单
     */
    OrderButtonVO CANCEL_ORDER    = new OrderButtonVO(OrderButtonEnum.CANCEL_ORDER.getType(), OrderButtonEnum.CANCEL_ORDER.getTypeName(), 0, OrderButtonEnum.CANCEL_ORDER.getSort());
    /**
     * 确认收货
     */
    OrderButtonVO CONFIRM_RECEIPT    = new OrderButtonVO(OrderButtonEnum.CONFIRM_RECEIPT.getType(), OrderButtonEnum.CONFIRM_RECEIPT.getTypeName(), 0, OrderButtonEnum.CONFIRM_RECEIPT.getSort());
    /**
     * 申请退款
     */
    OrderButtonVO APPLY_REFUND    = new OrderButtonVO(OrderButtonEnum.APPLY_REFUND.getType(), OrderButtonEnum.APPLY_REFUND.getTypeName(), 0, OrderButtonEnum.APPLY_REFUND.getSort());


}
