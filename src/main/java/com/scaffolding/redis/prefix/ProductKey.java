package com.scaffolding.redis.prefix;

import com.whhim.hxh.redis.BaseKeyPrefix;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/21 2:44 下午
 */
public class ProductKey extends BaseKeyPrefix {

    public final static String PRODUCT_PREFIX = "PRODUCT-";

    public ProductKey(String keyPrefix) {
        super(keyPrefix);
    }

    public ProductKey(String keyPrefix, int expireSeconds) {
        super(keyPrefix, expireSeconds);
    }

    public static ProductKey PRODUCT_KEY = new ProductKey(PRODUCT_PREFIX, BaseKeyPrefix.ONE_DAY);


}
