package com.scaffolding.service.app.mine.role;

import com.scaffolding.config.executor.AsyncThreadPoolExecutor;
import com.scaffolding.service.app.mine.role.template.IMineAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/27 11:40 上午
 */
@Service
public class MineService extends AbstractMineTemplate implements IMineAssembly {

    @Autowired
    @Qualifier(value = AsyncThreadPoolExecutor.COMMON_THREAD_POOL_EXECUTOR)
    protected ThreadPoolTaskExecutor executor;


}
