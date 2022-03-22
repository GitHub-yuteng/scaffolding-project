package com.scaffolding.redis.prefix;

import com.whhim.hxh.redis.BaseKeyPrefix;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/22 2:20 下午
 */
public class SubmitRepeatKey extends BaseKeyPrefix {

    public final static Integer EXPIRE_SECONDS = 3;

    public SubmitRepeatKey(String keyPrefix) {
        super(keyPrefix);
    }

    public SubmitRepeatKey(String keyPrefix, int expireSeconds) {
        super(keyPrefix, expireSeconds);
    }
}
