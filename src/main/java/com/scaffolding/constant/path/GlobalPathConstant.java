package com.scaffolding.constant.path;

/**
 * @author YT
 * @Date 2021/8/17
 * @Dec 全局常量池
 */
public interface GlobalPathConstant {

    String IM = "IM";
    /**
     * 版本
     */
    String VERSION_1 = "/v1";
    String VERSION_2 = "/v2";

    /**
     * 需要拦截登录信息的前缀
     */
    String INTERCEPT_PATH = "/api";
    /**
     * 不需要拦截用户信息的前缀
     */
    String OPEN_PATH = "/open";
    /**
     * bar
     */
    String HOME = "/home";
    String MESSAGE = "/message";
    String TOOLS = "/tools";
    String MINE = "/mine";

    /**
     * 登录
     */
    String LOGIN = "/login";
    /**
     * 订单
     */
    String ORDER_PATH = "/order";
    /**
     * 分享订单
     */
    String SHARE_ORDER_PATH = "/share/order";
    /**
     * 营销接口
     */
    String MARKETING_PATH = "/marketing";
    /**
     * 商详
     */
    String PRODUCT_PATH = "/product";
    /**
     * 售后
     */
    String REFUND_PATH = "/refund";
    String SHOPCART_PATH = "/shopCart";
    String PAY_PATH = "/pay";
}
