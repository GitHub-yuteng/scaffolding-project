package com.scaffolding.handler;

/**
 * @author whh-yt
 * @Date 2021/10/20
 * @Desc 请求处理器
 */
public interface Handler<T> {

    /**
     * 请求处理器
     * @param request 请求参数
     * @return
     */
    T processHandler(T request);
}
