package com.scaffolding.service.order.constant;


import com.scaffolding.controller.order.vo.OrderCellVO;
import com.scaffolding.service.order.enums.OrderTargetEnum;

/**
 * @Author: yt
 * @Date: 2021/07/07/16:27
 * @Description:
 */
public interface OrderCellConstant {

    String PICPATH_WAIT_PAY            = "https://static.fuhuibao.club/szh/imgfile/szh/1625704144387/20210708082904434571.png";
    String PICPATH_WAIT_DELIVERY       = "https://static.fuhuibao.club/szh/imgfile/szh/1625704157358/20210708082917412431.png";
    String PICPATH_WAIT_RECEIVE        = "https://static.fuhuibao.club/szh/imgfile/szh/1625704170131/20210708082930192885.png";
    String PICPATH_RECEIVED            = "https://static.fuhuibao.club/szh/imgfile/szh/1625704170131/20210708082930192885.png";
    String PICPATH_COMPLETEDD            = "https://static.fuhuibao.club/szh/imgfile/szh/1625704170131/20210708082930192885.png";
    String PICPATH_REFUND_AFTER        = "https://static.fuhuibao.club/szh/imgfile/szh/1625704181617/20210708082941671497.png";

    /**
     * 待支付
     */
    OrderCellVO WAIT_PAY = new OrderCellVO(OrderTargetEnum.WAIT_PAY.getType(), OrderTargetEnum.WAIT_PAY.getTypeName(), PICPATH_WAIT_PAY, false, 1);
    /**
     * 待发货
     */
    OrderCellVO WAIT_DELIVERY = new OrderCellVO(OrderTargetEnum.WAIT_DELIVERY.getType(), OrderTargetEnum.WAIT_DELIVERY.getTypeName(), PICPATH_WAIT_DELIVERY, false, 5);
    /**
     * 待收货
     */
    OrderCellVO WAIT_RECEIVE = new OrderCellVO(OrderTargetEnum.WAIT_RECEIVE.getType(), OrderTargetEnum.WAIT_RECEIVE.getTypeName(), PICPATH_WAIT_RECEIVE, false, 10);
    /**
     * 已收货
     */
    OrderCellVO RECEIVED = new OrderCellVO(OrderTargetEnum.RECEIVED.getType(), OrderTargetEnum.RECEIVED.getTypeName(), PICPATH_RECEIVED, false, 10);
    /**
     * 已完成
     */
    OrderCellVO COMPLETED = new OrderCellVO(OrderTargetEnum.COMPLETED.getType(), OrderTargetEnum.COMPLETED.getTypeName(), PICPATH_COMPLETEDD, false, 10);
    /**
     * 退款/售后
     */
    OrderCellVO REFUND_AFTER = new OrderCellVO(OrderTargetEnum.REFUND_AFTER.getType(), OrderTargetEnum.REFUND_AFTER.getTypeName(), PICPATH_REFUND_AFTER, false, 20);

    /**
     * 全部状态
     */
    OrderCellVO ALL_STATUS      = new OrderCellVO(OrderTargetEnum.ALL_STATUS.getType(), OrderTargetEnum.ALL_STATUS.getTypeName(), PICPATH_REFUND_AFTER, false, 20);
    /**
     * 待结算
     */
    OrderCellVO WAIT_SETTLEMENT = new OrderCellVO(OrderTargetEnum.WAIT_SETTLEMENT.getType(), OrderTargetEnum.WAIT_SETTLEMENT.getTypeName(), PICPATH_REFUND_AFTER, false, 20);
    /**
     * 已结算
     */
    OrderCellVO SETTLED         = new OrderCellVO(OrderTargetEnum.SETTLED.getType(), OrderTargetEnum.SETTLED.getTypeName(), PICPATH_REFUND_AFTER, false, 20);
    /**
     * 已失效
     */
    OrderCellVO INVALID         = new OrderCellVO(OrderTargetEnum.INVALID.getType(), OrderTargetEnum.INVALID.getTypeName(), PICPATH_REFUND_AFTER, false, 20);

}
