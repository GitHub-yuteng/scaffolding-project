package com.scaffolding.service.shopCart.observer.subject;

import com.whhim.hxh.service.shopCart.dto.ShopCartDTO;
import com.whhim.hxh.service.shopCart.observer.CartObserver;

/**
 * @Description: CartSubject 通知 CartObserver 变化
 * @Author whh-yt
 * @Date 2022/3/9 9:37 上午
 */
public interface CartSubject {

    void registerObserver(CartObserver observer);

    void removeObserver(CartObserver observer);

    ShopCartDTO notifyObservers(String userCode);
}
