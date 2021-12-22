package com.scaffolding.handler.request;

import com.scaffolding.handler.Handler;
import org.springframework.stereotype.Component;

/**
 * @author whh-yt
 * @Date 2021/10/20
 * @Desc 请求处理类
 */
@Component
public class RequestHandler<T> implements Handler<T> {

    @Override
    public T processHandler(T request) {
        return request;
    }
}
