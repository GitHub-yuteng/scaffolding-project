package com.scaffolding.enums;

/**
 * @author whh-yt
 * @Date 2021/10/11
 * @Desc
 */
public enum ResponseStatusEnum {

    /**
     * 状态
     */
    SUCCESS         (0,  "success"),
    FAIL            (-1, "fail"),
    SERVER_ERROR    (-99,"server_error"),

    ;

    private final Integer type;
    private final String typeDesc;

    public Integer getType() {
        return type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    ResponseStatusEnum(Integer type, String typeDesc) {
        this.type = type;
        this.typeDesc = typeDesc;
    }
}
