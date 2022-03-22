package com.scaffolding.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlatformEnum {

    ANDROID ("Android", "安卓"),
    WECHAT  ("WeChat",  "小程序"),
    IOS     ("IOS",     "苹果"),
    WEB     ("WEB",     "网页"),

    ;
    /**
     * 平台代码
     */
    private final String platformCode;
    /**
     * 平台名称
     */
    private final String platformName;

    public static PlatformEnum getEnumByType(String type) {
        for (PlatformEnum platformEnum : PlatformEnum.values()) {
            if (platformEnum.getPlatformCode().equals(type)) {
                return platformEnum;
            }
        }
        return null;
    }
}