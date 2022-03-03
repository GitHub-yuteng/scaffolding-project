package com.scaffolding.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/18 1:47 下午
 */
public class DateUtil {

    public final static String DATE = "yyyy-MM-dd";
    public final static String TIME = "HH:mm:ss";
    public final static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME);


    /**
     * @param localDateTime
     * @return
     */
    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DateUtil.DATE_TIME));
    }

    /**
     * @param localDateTime
     * @return
     */
    public static String formatLocalTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DateUtil.TIME));
    }

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalDate now1 = LocalDate.now();
        System.out.println(now1);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        System.out.println("=========");

        System.out.println(formatLocalDateTime(LocalDateTime.now()));
        System.out.println(formatLocalTime(LocalDateTime.now()));

        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime());


    }

}
