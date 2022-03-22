package com.scaffolding.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/10 2:10 下午
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    CONSUMER        (1,"消费者"),
    DISTRIBUTER     (2,"分销员"),
    UNKNOWN         (-1,"未知"),
    ;

    private Integer type;
    private String typeName;

    public static UserTypeEnum getEnumByType(Integer type) {
        for (UserTypeEnum userTypeEnums : UserTypeEnum.values()) {
            if (userTypeEnums.getType().equals(type)) {
                return userTypeEnums;
            }
        }
        return UNKNOWN;
    }
}
