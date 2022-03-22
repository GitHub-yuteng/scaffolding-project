package com.scaffolding.service.order.constant;

/**
 * @Author: yt
 * @Date: 2021/06/01/8:10
 * @Description:
 */
public interface OrderMessageConstant {

    String PICTURE_STORE                  = "https://static.fuhuibao.club/szh/imgfile/szh/1626920583278/20210722102303318186.png";
    String PICTURE_PATH                   = "https://static.fuhuibao.club";

    String ORDER_REMINDER                 = "订单即将关闭, 请尽快付款";
    String USER_IS_NULL                   = "请重新登录";
    String UNPAID_ORDER_CLOSES_OVER_TIME  = "超时未支付订单关闭";
    String PAY_OVERTIME                   = "支付超时";
    String USER_CANCLE                    = "用户取消";
    String SHOP_CANCLE                    = "商家取消";


    /**
     * 订单相关报错信息
     */
    String CREATE_ORDER_ERROR           = "订单创建失败";
    String ORDER_ERROR                  = "订单异常";
    String ORDER_DOES_NOT_EXIST         = "订单不存在";
    String ORDER_TIME_FORMAT_ERROR      = "订单时间格式化错误";
    String ORDER_INFO_ERROR             = "订单信息异常, 请稍后再试";
    String GOODS_INFO_ERROR             = "商品信息异常, 请稍后再试";
    String ACTIVITY_INFO_ERROR          = "活动信息异常, 请稍后再试";
    String ORDER_NO_IS_NULL             = "订单编号为空";
    String ORDER_IS_NULL                = "订单不存在";
    String ORDERD_ITEM_NO_IS_NULL       = "订单信息行项目为空";
    String AFTER_SALE_ORDER_NO_IS_NULL  = "售后订单编号为空";
    String AFTER_SALE_ORDER_ERROR       = "售后订单信息异常, 请稍后再试";
    String AFTER_SALE_ORDER_IS_NUL      = "售后订单不存在";
    String SIGN_FAIL                    = "签收失败";
    String SIGN_FAIL_STATUS_ERROR       = "签收失败,订单状态异常";
    String ADD_CAR_ERROR                = "加入购物车失败";
    String CANCEL_ERROR                 = "取消订单失败";
    String PRICE_ERROR                  = "产品价格异常";

    /**
     * 订单发货相关信息
     */
    String DELIVERY_GOODS_IS_EMPTY          = "发货商品为空";
    String DELIVERY_GOODS_ERROR             = "商品发货失败";
    String DELIVERY_GOODS_ARE_EMPTY         = "可发货商品为空";
    String DELIVERY_TYPE_EXPRESS_TRANSPORT  = "快递物流";
    String DELIVERY_TYPE_ROAD_TRANSPORT     = "公路运输";
    String DELIVERY_TYPE_IS_ERROR           = "发货类型错误";

    /**
     * 物流相关信息
     */
    String LOGISTICS_IS_DUPLICATE       = "物流单号重复";
    String LOGISTICS_ERROR              = "物流查询失败";
}
