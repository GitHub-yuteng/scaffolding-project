package com.scaffolding.redis.prefix;

import com.whhim.hxh.redis.BaseKeyPrefix;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/21 2:39 下午
 */
public class UserTokenKey extends BaseKeyPrefix {

    public final static String PREFIX = "T-KEY";

    public UserTokenKey(String keyPrefix) {
        super(keyPrefix);
    }

    public UserTokenKey(String keyPrefix, int expireSeconds) {
        super(keyPrefix, expireSeconds);
    }

    public static UserTokenKey USER_TOKEN_KEY = new UserTokenKey(PREFIX, BaseKeyPrefix.ONE_WEEK);

}
