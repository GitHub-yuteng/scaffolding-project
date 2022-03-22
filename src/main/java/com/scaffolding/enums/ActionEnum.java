package com.scaffolding.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/14 3:18 下午
 */
@Getter
@AllArgsConstructor
public enum ActionEnum {

    ADD     (1, "添加"),
    UPDATE  (2, "更新"),
    DELETE  (3, "删除"),

    UNKNOWN (-99, "删除"),
    ;

    private Integer type;
    private String typeName;
}
