package com.scaffolding.service.app.mine.role.impl;

import com.scaffolding.service.app.mine.role.MineService;
import com.scaffolding.service.app.mine.role.impl.param.MineParam;
import com.scaffolding.service.app.mine.role.impl.param.TmMineParam;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/28 11:36 上午
 */
@Service
public class TmMineService extends MineService {

    @Override
    public MineInfoVO queryMineInfo() {
        MineInfoVO mineInfoVO = new MineInfoVO();
        TmMineParam tmMineParam = new TmMineParam();

        return mineInfoVO;
    }

    @Override
    public <T extends MineParam> void assemblyUserInfo(MineInfoVO mineInfo, T mineParam) {
        TmMineParam tmMineParam = (TmMineParam) mineParam;
    }

    @Override
    public <T extends MineParam> void assemblyOrderCells(MineInfoVO mineInfo, T mineParam) {
    }

    @Override
    public <T extends MineParam> void assemblyTools(MineInfoVO mineInfo, T mineParam) {

    }

}
