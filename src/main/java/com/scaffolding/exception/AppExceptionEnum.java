package com.scaffolding.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/31 11:06 上午
 */
@Getter
@AllArgsConstructor
public enum AppExceptionEnum {

    /**
     *
     */
    SYSTEM_ERROR            (10001,"系统报错");


    private int code;
    private String message;

}
