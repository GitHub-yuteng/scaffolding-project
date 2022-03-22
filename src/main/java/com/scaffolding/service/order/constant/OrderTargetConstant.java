package com.scaffolding.service.order.constant;


import com.whhim.hxh.controller.order.vo.OrderTargetVO;
import com.whhim.hxh.service.order.enums.OrderTargetEnum;

/**
 * @Author: yt
 * @Date: 2021/06/03/9:24
 * @Description:
 */
public interface OrderTargetConstant {

    /**
     * 全部
     */
    OrderTargetVO ALL = new OrderTargetVO(OrderTargetEnum.ALL.getType(), OrderTargetEnum.ALL.getTypeName(), false, OrderTargetEnum.ALL.getSort());
    /**
     * 待支付
     */
    OrderTargetVO WAIT_PAY = new OrderTargetVO(OrderTargetEnum.WAIT_PAY.getType(), OrderTargetEnum.WAIT_PAY.getTypeName(), false, OrderTargetEnum.WAIT_PAY.getSort());
    /**
     * 待发货
     */
    OrderTargetVO WAIT_DELIVERY = new OrderTargetVO(OrderTargetEnum.WAIT_DELIVERY.getType(), OrderTargetEnum.WAIT_DELIVERY.getTypeName(), false, OrderTargetEnum.WAIT_DELIVERY.getSort());
    /**
     * 待收货
     */
    OrderTargetVO WAIT_RECEIVE = new OrderTargetVO(OrderTargetEnum.WAIT_RECEIVE.getType(), OrderTargetEnum.WAIT_RECEIVE.getTypeName(), false, OrderTargetEnum.WAIT_RECEIVE.getSort());
    /**
     * 已收货
     */
    OrderTargetVO RECEIVED = new OrderTargetVO(OrderTargetEnum.RECEIVED.getType(), OrderTargetEnum.RECEIVED.getTypeName(), false, OrderTargetEnum.RECEIVED.getSort());

    /**
     * 推广订单
     * 全部状态
     */
    OrderTargetVO ALL_STATUS = new OrderTargetVO(OrderTargetEnum.ALL_STATUS.getType(), OrderTargetEnum.ALL_STATUS.getTypeName(), false, OrderTargetEnum.ALL_STATUS.getSort());
    /**
     * 待结算
     */
    OrderTargetVO WAIT_SETTLEMENT = new OrderTargetVO(OrderTargetEnum.WAIT_SETTLEMENT.getType(), OrderTargetEnum.WAIT_SETTLEMENT.getTypeName(), false, OrderTargetEnum.WAIT_SETTLEMENT.getSort());
    /**
     * 已结算
     */
    OrderTargetVO SETTLED = new OrderTargetVO(OrderTargetEnum.SETTLED.getType(), OrderTargetEnum.SETTLED.getTypeName(), false, OrderTargetEnum.SETTLED.getSort());
    /**
     * 已失效
     */
    OrderTargetVO INVALID = new OrderTargetVO(OrderTargetEnum.INVALID.getType(), OrderTargetEnum.INVALID.getTypeName(), false, OrderTargetEnum.INVALID.getSort());

}
