package com.scaffolding.exception;

import java.io.Serializable;

/**
 * @author yt
 * @Date 2021/10/11
 * @Desc
 */
public class AppException extends RuntimeException implements Serializable {

    private Integer errorCode;
    private String message;
}
