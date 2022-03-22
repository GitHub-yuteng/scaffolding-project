package com.scaffolding.auth;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yt
 */
@Slf4j
public class Authentication {

    private static final ThreadLocal<UserInfo> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();

    public static void setUserInfoThreadLocal(UserInfo _userInfo) {
        USER_INFO_THREAD_LOCAL.set(_userInfo);
    }

    public static void remove() {
        USER_INFO_THREAD_LOCAL.remove();
    }

    public static UserInfo getUserInfo() {
        return USER_INFO_THREAD_LOCAL.get();
    }
}