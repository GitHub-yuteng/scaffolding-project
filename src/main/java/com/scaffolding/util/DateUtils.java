package com.scaffolding.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/18 1:47 下午
 */
public class DateUtils {

    public final static String DATE = "yyyy-MM-dd";
    public final static String TIME = "HH:mm:ss";
    public final static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME);


    /**
     * @param localDateTime
     * @return
     */
    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DateUtils.DATE_TIME));
    }

    /**
     * @param localDateTime
     * @return
     */
    public static String formatLocalTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(DateUtils.TIME));
    }

    /**
     * 获取日期时间的年份，如2022-02-13，返回2022
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取日期时间的月份，如2022年2月13日，返回2
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期时间的第几天（即返回日期的dd），如2022-02-13，返回13
     */
    public static int getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * 添加 x 小时
     */
    public static LocalDateTime addHours(LocalDateTime source, int i) {
        return source.plusHours(i);
    }

    /**
     * 添加 x 小时
     */
    public static LocalDateTime addDays(LocalDateTime source, int i) {
        return source.plusDays(i);
    }

    /**
     * 转时间戳
     * @param source
     * @return
     */
    public static Long LocalDateTime2TimeStamp(LocalDateTime source) {
        return source.toEpochSecond(ZoneOffset.of("+8"));
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

        System.out.println("=============");
        LocalDateTime createTime = LocalDateTime.now();
        System.out.println(createTime);
        System.out.println(addHours(createTime, 1));
        System.out.println(createTime);

    }
}
