package com.scaffolding.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther YT
 * @Date 2021/8/17
 */
@Getter
@AllArgsConstructor
public enum ResponseResultEnum {

    /**
     * 返回值状态
     */
    SUCCESS    (200,"成功"),
    ERROR      (500,"失败"),
    UNKNOWN    (-99,"未知"),
    ;

    private final Integer type;
    private final String typeName;
}
