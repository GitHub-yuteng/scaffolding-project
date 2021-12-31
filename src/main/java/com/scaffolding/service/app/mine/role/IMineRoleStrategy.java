package com.scaffolding.service.app.mine.role;

import com.scaffolding.service.app.mine.vo.MineInfoVO;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/28 11:35 上午
 */
public interface IMineRoleStrategy {

    /**
     * 查看我的
     * @return
     */
    MineInfoVO queryMineInfo();
}
