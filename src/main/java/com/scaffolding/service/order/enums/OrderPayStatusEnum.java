package com.scaffolding.service.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 11:02 上午
 */
@Getter
@AllArgsConstructor
public enum OrderPayStatusEnum {

    UN_PAY  (0, "未支付"),
    PAY     (1, "已支付"),
    ;

    private final Integer type;
    private final String typeName;
}
