package com.scaffolding.response;

import java.io.Serializable;

/**
 * @author yt
 */
public class ResponseResult<T> implements Serializable {

    private ResponseStatus responseStatus;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(ResponseStatus responseStatus, T data) {
        this.responseStatus = responseStatus;
        this.data = data;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public T getData() {
        return data;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        ResponseResult<T> restResult = new ResponseResult<>();
        restResult.setResponseStatus(ResponseStatus.SUCCESS);
        return restResult;
    }

    public static <T> ResponseResult<T> fail(String message) {
        ResponseResult<T> restResult = new ResponseResult<>();
        restResult.setResponseStatus(ResponseStatus.FAIL);
        return restResult;
    }
}