package com.scaffolding.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@EnableAsync
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        String realKey = prefix.getKeyPrefix() + key;
        String str = stringRedisTemplate.opsForValue().get(realKey);
        return jsonToBean(str, clazz);
    }

    public String get(KeyPrefix prefix, String key) {
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.opsForValue().get(realKey);
    }

    /**
     * 设置对象
     *
     * @return
     */
    public <T> void set(KeyPrefix prefix, String key, T value) {
        String str = beanToJson(value);
        if (str == null || str.length() <= 0) {
            return;
        }
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        int seconds = prefix.expireSeconds();
        if (seconds <= 0) {
            stringRedisTemplate.opsForValue().set(realKey, str);
        } else {
            stringRedisTemplate.opsForValue().set(realKey, str, seconds, TimeUnit.SECONDS);
        }
    }

    /**
     * Set key to hold the string value if key is absent.
     * setNx 有key值 set 返回 null, 无key值 相当于 set
     */
    public boolean setNx(KeyPrefix prefix, String key, String value) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        int timeout = prefix.expireSeconds();
        return stringRedisTemplate.opsForValue().setIfAbsent(realKey, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * Set key to hold the string value if key is present.
     * setNx 有key值 set 覆盖value, 无key值set 返回 null
     */
    public Boolean setXx(KeyPrefix prefix, String key, String value) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        int timeout = prefix.expireSeconds();
        return stringRedisTemplate.opsForValue().setIfPresent(realKey, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     */
    public boolean exists(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.hasKey(realKey);
    }

    /**
     * 设置对象过期时间
     */
    public void expire(KeyPrefix prefix, String key) {
        String realKey = prefix.getKeyPrefix() + key;
        int seconds = prefix.expireSeconds();
        stringRedisTemplate.expire(realKey, seconds, TimeUnit.SECONDS);
    }

    /**
     * 删除
     */
    public Boolean delete(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.delete(realKey);
    }

    /**
     * 增加值
     */
    public Long incr(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.opsForValue().increment(realKey);
    }


    /**
     * 自增并设置过期时间
     *
     * @param prefix
     * @param key
     * @param expireSec
     * @param <T>
     * @return
     */
    public <T> Long incrAndSetExpireSec(KeyPrefix prefix, String key, Long expireSec) {
        String realKey = prefix.getKeyPrefix() + key;
        Long ret = stringRedisTemplate.opsForValue().increment(realKey);
        // 设置过期时间
        stringRedisTemplate.expire(realKey, expireSec, TimeUnit.SECONDS);
        return ret;
    }

    /**
     * 减少值
     */
    public Long decr(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.opsForValue().decrement(realKey);
    }

    /**
     * 减少指定值
     */
    public Long decrBy(KeyPrefix prefix, String key, Integer count) {
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.opsForValue().decrement(realKey, count);
    }

    /**
     * 缓存中增加指定数量
     *
     * @param prefix
     * @param key
     * @param count
     * @param <T>
     * @return
     */
    public Long incrBy(KeyPrefix prefix, String key, Integer count) {
        String realKey = prefix.getKeyPrefix() + key;
        return stringRedisTemplate.opsForValue().increment(realKey, count);
    }

    public <T> Long setList(KeyPrefix prefix, String key, List<T> value) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        String s = JSONArray.toJSONString(value);
        return stringRedisTemplate.opsForList().leftPush(realKey, s);
    }

    public <T> void setJsonList(KeyPrefix prefix, String key, List<T> value) {
        //生成真正的key
        String realKey = prefix.getKeyPrefix() + key;
        String jsonStr = JSONArray.toJSONString(value);

        int seconds = prefix.expireSeconds();
        if (seconds <= 0) {
            stringRedisTemplate.opsForValue().set(realKey, jsonStr);
        } else {
            stringRedisTemplate.opsForValue().set(realKey, jsonStr, seconds, TimeUnit.SECONDS);
        }
    }

    public static String beanToJson(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        return JSON.toJSONString(obj);
    }

    @SuppressWarnings("unchecked")
    public static <T> T jsonToBean(String str, Class<T> clazz) {
        if (StringUtils.isBlank(str) || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else if (clazz == List.class) {
            return JSON.toJavaObject(JSON.parseArray(str), clazz);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

}

