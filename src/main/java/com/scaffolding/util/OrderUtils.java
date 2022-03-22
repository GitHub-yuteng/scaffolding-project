package com.scaffolding.util;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.UUID;

/**
 * @Description: 订单相关工具方法
 * @Author whh-yt
 * @Date 2022/3/9 1:12 下午
 */
public class OrderUtils {

    private final static String H = "H";
    private final static Integer RANDOM_TIMES = 5;
    private final static SecureRandom SECURE_RANDOM = new SecureRandom();
    private final static String BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 创建一个订单号 供下单使用
     *
     * @return
     */
    public static String createOrderNo() {
        StringBuilder builder = new StringBuilder();
        builder.append(OrderUtils.H);
        Calendar calendar = Calendar.getInstance();
        builder.append(calendar.get(Calendar.YEAR));
        builder.append(calendar.get(Calendar.MONTH) + 1);
        builder.append(calendar.get(Calendar.DATE));
        builder.append(System.currentTimeMillis());
        for (int i = 0; i < OrderUtils.RANDOM_TIMES; i++) {
            int number = OrderUtils.SECURE_RANDOM.nextInt(OrderUtils.BASE.length());
            builder.append(OrderUtils.BASE.charAt(number));
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        createOrderNo();
    }
}
