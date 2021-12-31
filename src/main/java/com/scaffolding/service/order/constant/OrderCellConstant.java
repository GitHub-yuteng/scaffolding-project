package com.scaffolding.service.order.constant;

import com.scaffolding.pojo.vo.CellVO;
import com.scaffolding.service.order.enums.OrderTargetEnum;
import lombok.Data;

/**
 * @Author: yt
 * @Date: 2021/07/07/16:27
 * @Description:
 */
@Data
public class OrderCellConstant {

    private static final String PICPATH_ALL                 = "https://static.fuhuibao.club/szh/imgfile/szh/1625704104656/20210708082824704820.png";
    private static final String PICPATH_WAIT_PAY            = "https://static.fuhuibao.club/szh/imgfile/szh/1625704144387/20210708082904434571.png";
    private static final String PICPATH_WAIT_DELIVERY       = "https://static.fuhuibao.club/szh/imgfile/szh/1625704157358/20210708082917412431.png";
    private static final String PICPATH_WAIT_WAIT_ACCEPT    = "https://static.fuhuibao.club/szh/imgfile/szh/1625704170131/20210708082930192885.png";
    private static final String PICPATH_WAIT_RECEIVE        = "https://static.fuhuibao.club/szh/imgfile/szh/1625704170131/20210708082930192885.png";
    private static final String PICPATH_WAIT_SIGN           = "https://static.fuhuibao.club/szh/imgfile/szh/1625704170131/20210708082930192885.png";
    private static final String PICPATH_WAIT_EVALUATION     = "https://static.fuhuibao.club/szh/imgfile/szh/1625704104656/20210708082824704820.png";
    private static final String PICPATH_REFUND_AFTER        = "https://static.fuhuibao.club/szh/imgfile/szh/1625704181617/20210708082941671497.png";

    private static final String DISPLAY_ALL_ORDER       = "全部订单";
    private static final String DISPLAY_WAIT_PAY        = "待支付";
    private static final String DISPLAY_WAIT_DELIVERY   = "待发货";
    private static final String DISPLAY_WAIT_ACCEPT     = "待接单";
    private static final String DISPLAY_WAIT_RECEIVE    = "待收货";
    private static final String DISPLAY_WAIT_SIGN       = "待签收";
    private static final String DISPLAY_WAIT_EVALUATION = "待评价";
    private static final String DISPLAY_REFUND_AFTER    = "退款/售后";

    /**
     * 全部
     */
    public static final CellVO ALL = new CellVO(OrderTargetEnum.ALL.getType(), DISPLAY_ALL_ORDER, PICPATH_ALL, false, 99);
    /**
     * 待支付
     */
    public static final CellVO WAIT_PAY = new CellVO(OrderTargetEnum.WAIT_PAY.getType(), DISPLAY_WAIT_PAY, PICPATH_WAIT_PAY, false, 1);
    /**
     * 待发货
     */
    public static final CellVO WAIT_DELIVERY = new CellVO(OrderTargetEnum.WAIT_DELIVERY.getType(), DISPLAY_WAIT_DELIVERY, PICPATH_WAIT_DELIVERY, false, 5);
    /**
     * 待收货
     */
    public static final CellVO WAIT_RECEIVE = new CellVO(OrderTargetEnum.WAIT_RECEIVE.getType(), DISPLAY_WAIT_RECEIVE, PICPATH_WAIT_RECEIVE, false, 10);
    /**
     * 待签收
     */
    public static final CellVO WAIT_SIGN = new CellVO(OrderTargetEnum.WAIT_SIGN.getType(), DISPLAY_WAIT_SIGN, PICPATH_WAIT_SIGN, false, 10);
    /**
     * 待评价
     */
    public static final CellVO WAIT_EVALUATION = new CellVO(OrderTargetEnum.WAIT_EVALUATION.getType(), DISPLAY_WAIT_EVALUATION, PICPATH_WAIT_EVALUATION, false, 15);
    /**
     * 退款/售后
     */
    public static final CellVO REFUND_AFTER_MINE = new CellVO(OrderTargetEnum.REFUND_AFTER_MINE.getType(), DISPLAY_REFUND_AFTER, PICPATH_REFUND_AFTER, false, 20);
    public static final CellVO REFUND_AFTER_HOME = new CellVO(OrderTargetEnum.REFUND_AFTER_HOME.getType(), DISPLAY_REFUND_AFTER, PICPATH_REFUND_AFTER, false, 20);

}
