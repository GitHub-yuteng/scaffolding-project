package com.scaffolding.service.shopCart.observer.subject;

import com.whhim.hxh.redis.RedisService;
import com.whhim.hxh.redis.prefix.ShopCartKey;
import com.whhim.hxh.service.shopCart.dto.ShopCartDTO;
import com.whhim.hxh.service.shopCart.observer.CartObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 9:58 上午
 */
@Component
public class CartDataSubject implements CartSubject {

    @Autowired
    private RedisService redisService;
    @Autowired
    private CartObserver shopCartObserver;

    /**
     * 主动推送
     */
    public void active(String userCode) {
        notifyObservers(userCode);
    }

    @Override
    public void registerObserver(CartObserver observer) {
        this.shopCartObserver = observer;
    }

    @Override
    public void removeObserver(CartObserver observer) {

    }

    @Override
    public ShopCartDTO notifyObservers(String userCode) {
        return redisService.get(ShopCartKey.SHOP_CART_KEY, userCode, ShopCartDTO.class);
    }
}
