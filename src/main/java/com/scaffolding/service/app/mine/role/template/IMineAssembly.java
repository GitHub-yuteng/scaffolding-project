package com.scaffolding.service.app.mine.role.template;

import com.scaffolding.service.app.mine.role.impl.param.MineParam;
import com.scaffolding.service.app.mine.vo.MineInfoVO;

/**
 * @Author: yt
 * @Date: 2021/06/18/14:58
 * @Description: 将需要组装的方法抽象
 */
public interface IMineAssembly {

    /**
     * 组装用户信息
     *
     * @param mineInfo
     * @param mineParam
     */
    <T extends MineParam> void assemblyUserInfo(MineInfoVO mineInfo, T mineParam);

    /**
     * 组装订单cell
     *
     * @param mineInfo
     * @param mineParam
     */
    <T extends MineParam> void assemblyOrderCells(MineInfoVO mineInfo, T mineParam);

    /**
     * 组装我的工具
     *
     * @param mineInfo
     * @param mineParam
     */
    <T extends MineParam> void assemblyTools(MineInfoVO mineInfo, T mineParam);

}
