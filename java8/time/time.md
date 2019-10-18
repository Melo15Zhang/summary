# 时间日期API(java8学习1)

<p>新的时间日期库的最大的优点，它定义清楚了时间日期相关的一些概念：</p>
<ul>
    <li>瞬时时间(Instant)</li>
    <li>持续时间(Duration)</li>
    <li>日期(Date)</li>
    <li>时间(time)</li>
    <li>时区(time-zone)</li>
    <li>时间段(Period)</li>
</ul>
具体如下：
<ul>
    <li>Instant——它代表的是时间戳</li>
    <li>Duration——它代表的是时间段，以秒和纳秒为单位模拟时间量</li>
    <li>LocalDate——不包含具体时间的日期，比如2014-01-14。可用来存储生日，周年纪念日，入职日期等。</li>
    <li>LocalTime——它代表的是不含日期的时间</li>
    <li>LocalDateTime——它包含了日期及时间，不过还是没有偏移信息或者说时区。</li>
    <li>ZonedDateTime——这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。</li>
    <li>Period——以年，月和日为单位来模拟数量或时间量</li>
</ul>

### 常用的时间处理如下：

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




