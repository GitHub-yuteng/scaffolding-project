package com.scaffolding.service.app.mine.role;

import com.scaffolding.service.app.mine.role.impl.param.MineParam;
import com.scaffolding.service.app.mine.role.template.IMineAssembly;
import com.scaffolding.service.app.mine.vo.MineInfoVO;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/28 11:40 上午
 */
public abstract class AbstractMineTemplate implements IMineAssembly {

    /**
     * 模版方法，final 不让子类覆盖
     */
    protected final <T extends MineParam> void defaultTemplate(MineInfoVO mineInfo, T mineParam) {
        assemblyUserInfo(mineInfo, mineParam);
        assemblyOrderCells(mineInfo, mineParam);
        assemblyTools(mineInfo, mineParam);
    }


    /**
     * 模版方法，final 不让子类覆盖
     */
    protected final <T extends MineParam> void tmMineTemplate(MineInfoVO mineInfo, T mineParam) {
        defaultTemplate(mineInfo, mineParam);
    }
}
