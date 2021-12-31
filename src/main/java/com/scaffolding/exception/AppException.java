package com.scaffolding.exception;

import java.io.Serializable;

/**
 * @author yt
 * @Date 2021/10/11
 * @Desc
 */
public class AppException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 713066443150287664L;

    private static final String APP_PREFIX  = "APP";
    private static final String SYS_PREFIX  = "system";
    private static final String SPLIT_STRING = "$#$";
    private static final String APP_ERR_MSG = "应用程序出错";
    private static final String SYS_ERR_MSG = "系统出错";

    private Integer errorCode;
    private String errorMessage;

    public AppException(String string) {
        super(string);
        this.errorCode = 0;
        this.errorMessage = string;
    }
}
