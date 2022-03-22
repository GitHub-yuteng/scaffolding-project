package com.scaffolding.redis;

/**
 * @author whh-yt
 */
public interface KeyPrefix {

    /**
     * 到期时间
     * @return
     */
    int expireSeconds();

    /**
     * 获取key前缀
     * @return
     */
    String getKeyPrefix();
}