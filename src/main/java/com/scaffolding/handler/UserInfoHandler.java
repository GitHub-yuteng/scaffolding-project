package com.scaffolding.handler;

import com.scaffolding.handler.request.PassRequest;
import org.springframework.stereotype.Component;

/**
 * @author yt
 * @Date 2021/10/20
 * @Desc
 */
@Component
public class UserInfoHandler implements Handler<PassRequest> {

    /**
     *
     * @param request 请求体
     * @return
     */
    @Override
    public PassRequest processHandler(PassRequest request) {
        return request;
    }
}
