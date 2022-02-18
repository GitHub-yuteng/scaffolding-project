package com.scaffolding.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/30 5:15 下午
 */
public class JacksonUtil {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    // 对Jackson 进行配置
    static {
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public static String toJsonString(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
