package com.scaffolding.service.order.model;

import com.scaffolding.service.app.mine.vo.MineInfoVO;

/**
 * @Author: yt
 * @Date: 2021/06/02/15:26
 * @Description: 订单模式功能
 */
public interface IOrderModelStrategy {

    /**
     * 查询我的
     * @return
     */
    MineInfoVO queryMineInfo();
}
