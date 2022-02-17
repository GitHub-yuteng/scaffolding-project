package com.scaffolding.wxpay.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/17 1:49 下午
 */
public interface WxPayErrorEnums {

    /**
     * 除付款码支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再按Native、JSAPI、APP等不同场景生成交易串调起支付。
     */
    @Getter
    @AllArgsConstructor
    enum JsApiPayEnum {

        USERPAYING              (202, "USERPAYING",             "用户支付中，需要输入密码"),
        TRADE_ERROR             (403, "TRADE_ERROR",            "交易错误"),
        SYSTEMERROR             (500, "SYSTEMERROR",            "系统错误"),
        SIGN_ERROR              (401, "SIGN_ERROR",             "签名错误"),
        RULELIMIT               (403, "RULELIMIT",              "业务规则限制"),
        PARAM_ERROR             (400, "PARAM_ERROR",            "参数错误"),
        OUT_TRADE_NO_USED       (403, "OUT_TRADE_NO_USED",      "商户订单号重复"),
        ORDERNOTEXIST           (404, "ORDERNOTEXIST",          "订单不存在"),
        ORDER_CLOSED            (400, "ORDER_CLOSED",           "订单已关闭"),
        OPENID_MISMATCH         (500, "OPENID_MISMATCH",        "openid和appid不匹配"),
        NOTENOUGH               (403, "NOTENOUGH",              "余额不足"),
        NOAUTH                  (403, "NOAUTH",                 "商户无权限"),
        MCH_NOT_EXISTS          (400, "MCH_NOT_EXISTS",         "商户号不存在"),
        INVALID_TRANSACTIONID   (500, "INVALID_TRANSACTIONID",  "订单号非法"),
        INVALID_REQUEST         (400, "INVALID_REQUEST",        "无效请求"),
        FREQUENCY_LIMITED       (429, "FREQUENCY_LIMITED",      "频率超限"),
        BANKERROR               (500, "BANKERROR",              "银行系统异常"),
        APPID_MCHID_NOT_MATCH   (400, "APPID_MCHID_NOT_MATCH",  "appid和mch_id不匹配"),
        ACCOUNTERROR            (403, "ACCOUNTERROR",           "账号异常");

        private final Integer statusCode;
        private final String errorCode;
        private final String errorDesc;

        public static JsApiPayEnum getEnumByStatusCode(Integer statusCode) {
            for (JsApiPayEnum jsApiPayEnum : JsApiPayEnum.values()) {
                if (jsApiPayEnum.getStatusCode().equals(statusCode)) {
                    return jsApiPayEnum;
                }
            }
            return null;
        }

        public static JsApiPayEnum getEnumByErrorCode(String errorCode) {
            for (JsApiPayEnum jsApiPayEnum : JsApiPayEnum.values()) {
                if (jsApiPayEnum.getErrorCode().equals(errorCode)) {
                    return jsApiPayEnum;
                }
            }
            return null;
        }
    }

    enum AppPayEnum {

    }

    enum H5PayEnum {

    }

    enum NativePayEnum {

    }

    enum SmallProgramPayEnum {

    }


}
