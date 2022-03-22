package com.scaffolding.redis;

import java.util.Random;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/21 2:30 下午
 */
public class BaseKeyPrefix implements KeyPrefix {

    private final static Random RANDOM = new Random();

    public final static int ONE_DAY = 60 * 60 * 24;
    public final static int ONE_WEEK = 60 * 60 * 24 * 7;
    public final static int ONE_MONTH = 60 * 60 * 24 * 30;
    public final static int TWO_MONTH = 60 * 60 * 24 * 30 * 2;

    /**
     * key前缀
     */
    private final String keyPrefix;
    /**
     * 过期时间
     */
    private final int expireSeconds;

    public BaseKeyPrefix(String keyPrefix) {
        this(keyPrefix, 0);
    }

    /**
     * @param expireSeconds
     * @param keyPrefix
     */
    public BaseKeyPrefix(String keyPrefix, int expireSeconds) {
        this.keyPrefix = keyPrefix;
        this.expireSeconds = expireSeconds;
    }

    @Override
    public int expireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getKeyPrefix() {
        return this.getClass().getSimpleName() + ":" + this.keyPrefix;
    }
}
