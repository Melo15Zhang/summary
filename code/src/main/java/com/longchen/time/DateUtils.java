package com.longchen.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期utils
 */
public final class DateUtils {

    private final static String[] WEEKDAYS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    private final static ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * 根据format获取当前时间的字符串
     *
     * @param formatString
     * @return
     */
    public static String getFormatDate(String formatString) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatString));
    }

    /**
     * 获取format格式指定date的字符串
     *
     * @param formatString
     * @param date
     * @return
     */
    public static String getFormatDate(String formatString, Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(formatString));
    }

    /**
     * long转日期格式
     *
     * @param formatString 日期格式
     * @param mills     时间戳
     */
    public static String getFormatDate(String formatString, long mills) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(formatString));
    }

    /**
     * 将时间按照格式转换成时间
     *
     * @param date
     * @param formatString
     * @return
     */
    public static Date getFormatDate(Date date, String formatString) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        localDateTime.format(DateTimeFormatter.ofPattern(formatString));
        return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
    }

    /**
     * 获取两个日期间间隔的天数
     *
     * @param start
     * @param end
     * @return 返回值说明
     */
    public static int getIntervalDays(Date start, Date end) {
        LocalDate startDate = LocalDateTime.ofInstant(start.toInstant(), ZONE_ID).toLocalDate();
        LocalDate endDate = LocalDateTime.ofInstant(end.toInstant(), ZONE_ID).toLocalDate();
        return Period.between(startDate, endDate).getDays();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return 返回值说明
     */
    public static Date getDateAfterDay(Date d, int day) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(d.toInstant(), ZONE_ID);
        return Date.from(localDateTime.plusDays(day).atZone(ZONE_ID).toInstant());
    }

    /**
     * 获取指定小时后的时间
     *
     * @param d
     * @param hour
     * @return 返回值说明
     */
    public static Date getDateAfterHour(Date d, int hour) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(d.toInstant(), ZONE_ID);
        return Date.from(localDateTime.plusHours(hour).atZone(ZONE_ID).toInstant());
    }

    /**
     * 获取指定分钟后的时间
     *
     * @param d
     * @param minutes
     * @return
     */
    public static Date getDateAfterMinute(Date d, int minutes) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(d.toInstant(), ZONE_ID);
        return Date.from(localDateTime.plusMinutes(minutes).atZone(ZONE_ID).toInstant());
    }

    /**
     * 获取时间的时分秒部分的字符串
     *
     * @param date
     * @return 返回值说明
     */
    public static String getTimePartInString(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID).toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return 返回值说明
     */
    public static Date getDateBefore(Date d, int day) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
        return Date.from(localDateTime.minusDays(day).atZone(ZONE_ID).toInstant());
    }

    /**
     * 获取当前的日期
     *
     * @return 返回值说明
     */
    public static Date getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        Instant instant = localDate.atStartOfDay().atZone(ZONE_ID).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取目标时间是星期几
     *
     * @param dt
     * @return 返回值说明
     */
    public static String getWeekOfDate(Date dt) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dt.toInstant(), ZONE_ID);
        return WEEKDAYS[localDateTime.getDayOfWeek().getValue()];
    }

    /**
     * 获取当天在一年中是第几天
     *
     * @return 返回值说明
     */
    public static int getDayOfYear() {
        return LocalDate.now().getDayOfYear();
    }
}
