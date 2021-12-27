package com.scaffolding.service.order.constant;

/**
 * @Author: yt
 * @Date: 2021/06/01/8:10
 * @Description:
 */
public class OrderConstant {

    public static final String PICTURE_STORE                  = "https://static.fuhuibao.club/szh/imgfile/szh/1626920583278/20210722102303318186.png";
    public static final String PICTURE_PATH                   = "https://static.fuhuibao.club";

    public static final String ORDER_REMINDER                 = "订单即将关闭, 请尽快付款";
    public static final String USER_IS_NULL                   = "请重新登录";
    public static final String ORDER_MODEL                    = "订单模式错误";
    public static final String NO_AFFILIATED_SHOP             = "您无挂靠经销商";
    public static final String NO_AFFILIATED_TM               = "当前业务员未挂靠终端";
    public static final String UNPAID_ORDER_CLOSES_OVER_TIME  = "超时未支付订单关闭";
    public static final String PAY_OVERTIME                   = "支付超时";
    public static final String USER_CANCLE                    = "用户取消";
    public static final String SHOP_CANCLE                    = "商家取消";


    /**
     * 订单相关报错信息
     */
    public static final String ORDER_DOES_NOT_EXIST         = "订单不存在";
    public static final String ORDER_TIME_FORMAT_ERROR      = "订单时间格式化错误";
    public static final String ORDER_INFO_ERROR             = "订单信息异常, 请稍后再试";
    public static final String GOODS_INFO_ERROR             = "商品信息异常, 请稍后再试";
    public static final String ACTIVITY_INFO_ERROR          = "活动信息异常, 请稍后再试";
    public static final String ORDER_NO_IS_NULL             = "订单编号为空";
    public static final String ORDER_IS_NULL                = "订单不存在";
    public static final String ORDERD_ITEM_NO_IS_NULL       = "订单信息行项目为空";
    public static final String AFTER_SALE_ORDER_NO_IS_NULL  = "售后订单编号为空";
    public static final String AFTER_SALE_ORDER_ERROR       = "售后订单信息异常, 请稍后再试";
    public static final String AFTER_SALE_ORDER_IS_NUL      = "售后订单不存在";
    public static final String SIGN_FAIL                    = "签收失败";
    public static final String SIGN_FAIL_STATUS_ERROR       = "签收失败,订单状态异常";
    public static final String ADD_CAR_ERROR                = "加入购物车失败";
    public static final String CANCEL_ERROR                 = "取消订单失败";
    public static final String DIRECT_ACCEPT_ORDER_ERROR    = "订单指派异常";
    public static final String PRICE_ERROR                  = "产品价格异常";
    public static final String SYNC_MIAOMIAN_ERROR          = "同步秒眠订单信息失败";

    /**
     * 订单发货相关信息
     */
    public static final String DELIVERY_GOODS_IS_EMPTY          = "发货商品为空";
    public static final String DELIVERY_GOODS_ERROR             = "商品发货失败";
    public static final String DELIVERY_GOODS_ARE_EMPTY         = "可发货商品为空";
    public static final String DELIVERY_TYPE_EXPRESS_TRANSPORT  = "快递物流";
    public static final String DELIVERY_TYPE_ROAD_TRANSPORT     = "公路运输";
    public static final String DELIVERY_TYPE_IS_ERROR           = "发货类型错误";

    /**
     * 物流相关信息
     */
    public static final String LOGISTICS_IS_DUPLICATE       = "物流单号重复";
    public static final String LOGISTICS_ERROR              = "物流查询失败";
}
