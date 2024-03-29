package com.scaffolding.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 信息脱敏工具类
 * @author yt
 */
public class PrivacyDimmerUtils {

    private static final String OVERLAY = "****";
    private static final int START = 3;
    private static final int END = 7;

    /**
     * 139****0504
     *
     * @param content
     * @return
     */
    public static String maskMobile(String content) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        return StringUtils.overlay(content, OVERLAY, START, END);
    }

    /**
     * 过滤邮箱账号
     * 132****99308084911
     *
     * @param email
     * @return
     */
    public static String maskEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return "";
        }
        String at = "@";
        if (!email.contains(at)) {
            return email;
        }
        int length = StringUtils.indexOf(email, at);
        String content = StringUtils.substring(email, 0, length);
        String mask = StringUtils.overlay(content, OVERLAY, START, END);
        return mask + StringUtils.substring(email, length);
    }

    /**
     * 身份证打码操作
     * 132****99308084911
     *
     * @param idCard
     * @return
     */
    public static String maskIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return "";
        }
        return StringUtils.overlay(idCard, OVERLAY, START, END);
    }
}