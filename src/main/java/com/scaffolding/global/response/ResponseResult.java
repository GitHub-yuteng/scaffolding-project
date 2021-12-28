package com.scaffolding.global.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/28 11:04 上午
 */
@Data
public class ResponseResult<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    public static ResponseResult success() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(ResponseStatusEnum.SUCCESS.getCode());
        responseResult.setMessage(ResponseStatusEnum.SUCCESS.getDescribe());
        return responseResult;
    }

    public static <T> ResponseResult<T> success(String message) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setStatus(ResponseStatusEnum.SUCCESS.getCode());
        responseResult.setMessage(message);
        return responseResult;
    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setStatus(ResponseStatusEnum.SUCCESS.getCode());
        responseResult.setMessage(ResponseStatusEnum.SUCCESS.getDescribe());
        responseResult.setData(data);
        return responseResult;
    }

    public static <T> ResponseResult<T> success(int code, String describe, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setStatus(code);
        responseResult.setMessage(describe);
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult fail() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(ResponseStatusEnum.FAIL.getCode());
        responseResult.setMessage(ResponseStatusEnum.FAIL.getDescribe());
        return responseResult;
    }

    public static <T> ResponseResult<T> fail(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setStatus(ResponseStatusEnum.FAIL.getCode());
        responseResult.setMessage(ResponseStatusEnum.FAIL.getDescribe());
        responseResult.setData(data);
        return responseResult;
    }

    public static <T> ResponseResult<T> fail(String message) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setStatus(ResponseStatusEnum.FAIL.getCode());
        responseResult.setMessage(message);
        return responseResult;
    }

    public static <T> ResponseResult<T> fail(int code, String describe, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setStatus(code);
        responseResult.setMessage(describe);
        responseResult.setData(data);
        return responseResult;
    }


}
