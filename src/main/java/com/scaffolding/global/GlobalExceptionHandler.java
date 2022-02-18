package com.scaffolding.global;

import com.scaffolding.exception.AppException;
import com.scaffolding.exception.RepeatSubmitException;
import com.scaffolding.global.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局统一的异常处理，根据自己的业务要求详细配置
 * @author whh-yt
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 重复请求的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(RepeatSubmitException.class)
    public ResponseResult onException(RepeatSubmitException ex){
        //打印日志
        log.error(ex.getMessage());
        //统一结果返回
        return ResponseResult.fail();
    }

    /**
     * AppException处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AppException.class)
    public ResponseResult appExceptionHandler(AppException e) {
        log.warn("AppException:{}", e.getMessage());
        // 然后提取错误提示信息进行返回
        return ResponseResult.fail();
    }

    /**
     * 捕获一些进入controller之前的异常，有些4xx的状态码统一设置为200
     * @param ex
     * @return
     */
    @ExceptionHandler({
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpMediaTypeNotAcceptableException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MissingServletRequestPartException.class,
            BindException.class,
            NoHandlerFoundException.class,
            AsyncRequestTimeoutException.class})
    public ResponseResult onException(Exception ex){
        //打印日志
        log.error(ex.getMessage());
        //统一结果返回
        return ResponseResult.fail();
    }
}