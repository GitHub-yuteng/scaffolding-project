package com.scaffolding.wxpay.req;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/17 2:31 下午
 */
public class WxPayCommitReq {

    /**
     * 服务商应用ID
     */
    private String sp_appid;
    private String sp_mchid;
    private String sub_appid;
    private String sub_mchid;
    private String description;
    private String out_trade_no;
    private String time_expire;
    private String attach;
    private String notify_url;
    private String goods_tag;
}
