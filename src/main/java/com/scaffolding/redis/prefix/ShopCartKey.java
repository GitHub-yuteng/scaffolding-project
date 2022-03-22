package com.scaffolding.redis.prefix;

import com.whhim.hxh.redis.BaseKeyPrefix;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 4:28 下午
 */
public class ShopCartKey extends BaseKeyPrefix {

    private final static String PREFIX = "SHOP_CART";

    public ShopCartKey(String keyPrefix) {
        super(keyPrefix);
    }

    public ShopCartKey(String keyPrefix, int expireSeconds) {
        super(keyPrefix, expireSeconds);
    }

    /**
     * 购物车永不过期
     */
    public static ShopCartKey SHOP_CART_KEY = new ShopCartKey(ShopCartKey.PREFIX, -1);


}
