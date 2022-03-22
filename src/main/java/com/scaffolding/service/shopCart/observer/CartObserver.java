package com.scaffolding.service.shopCart.observer;

import com.whhim.hxh.controller.shopCart.vo.ShopCartVO;
import com.whhim.hxh.service.shopCart.dto.ShopCartDTO;

/**
 * @Description: 购物车观察者
 * @Author whh-yt
 * @Date 2022/3/9 9:50 上午
 */
public interface CartObserver {

    ShopCartVO change(ShopCartDTO shopCartDTO);
}
