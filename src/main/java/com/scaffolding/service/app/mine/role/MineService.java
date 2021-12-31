package com.scaffolding.service.app.mine.role;

import com.scaffolding.config.executor.AsyncThreadPoolExecutor;
import com.scaffolding.service.app.mine.dto.MineParamDTO;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
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
public class MineService extends AbstractMineTemplate implements IMineRoleStrategy  {

    @Autowired
    @Qualifier(value = AsyncThreadPoolExecutor.COMMON_THREAD_POOL_EXECUTOR)
    protected ThreadPoolTaskExecutor executor;

    @Override
    public MineInfoVO queryMineInfo() {
        MineInfoVO mineInfoVO = new MineInfoVO();
        // 多线程查询用户数据 装入 paramDTO 使用模板组装

        MineParamDTO mineParamDTO = new MineParamDTO();
        super.defaultTemplate(mineInfoVO,mineParamDTO);
        return mineInfoVO;
    }

    @Override
    public void assemblyUserInfo(MineInfoVO mineInfo, MineParamDTO mineParam) {

    }

    @Override
    public void assemblyOrderCells(MineInfoVO mineInfo, MineParamDTO mineParam) {

    }

    @Override
    public void assemblyTools(MineInfoVO mineInfo, MineParamDTO mineParam) {

    }
}
