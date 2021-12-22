package com.scaffolding.handler.request.impl;

import com.scaffolding.handler.request.RequestHandler;
import org.springframework.stereotype.Component;

/**
 * @author whh-yt
 * @Date 2021/10/20
 * @Desc
 *
 * 漏桶算法与令牌桶算法在表面看起来类似，很容易将两者混淆。
 * 但事实上，这两者具有截然不同的特性，且为不同的目的而使用。漏桶算法与令牌桶算法的区别在于：
 * 漏桶: 算法能够强行限制数据的传输速率。
 * 令牌桶算法: 能够在限制数据的平均传输速率的同时还允许某种程度的突发传输。
 *
 * 需要说明的是：在某些情况下，漏桶算法不能够有效地使用网络资源。因为漏桶的漏出速率是固定的，所以即使网络中没有发生拥塞，漏桶算法也不能使某一个单独的数据流达到端口速率。
 * 因此，漏桶算法对于存在突发特性的流量来说缺乏效率。而令牌桶算法则能够满足这些具有突发特性的流量。通常，漏桶算法与令牌桶算法结合起来为网络流量提供更高效的控制。
 */
@Component
public class TpsRequestHandler<PassRequest> extends RequestHandler<PassRequest> {

    @Override
    public PassRequest processHandler(PassRequest request) {
        return request;
    }
}
