package com.scaffolding.response.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private String messageId;
    private String message;
    private Integer statusCode;
    private T data;

}