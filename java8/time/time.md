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

参考链接：
https://cloud.tencent.com/developer/article/1340945

对应使用例子：
https://github.com/Melo15Zhang/summary/blob/master/code/src/main/java/com/longchen/time/DateUtils.java