package com.scaffolding.service.order.model;

import com.scaffolding.config.executor.AsyncThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 11:40 上午
 */
@Service
public class OrderService extends AbstractOrderTemplate implements IOrderModelStrategy {

    @Autowired
    @Qualifier(value = AsyncThreadPoolExecutor.COMMON_THREAD_POOL_EXECUTOR)
    protected ThreadPoolTaskExecutor executor;


}
