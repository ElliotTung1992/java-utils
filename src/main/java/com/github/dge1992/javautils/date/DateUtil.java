package com.github.dge1992.javautils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author dongganen
 * @date 2019/7/26
 * @desc: 日期工具类
 */
public class DateUtil {

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: localDate -> Date
     */
    public static Date getDateFromLocalDate(LocalDate localDate){
        ZonedDateTime atZone = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: LocalDateTime -> Date
     */
    public static Date getDateFromLocalDateTime(LocalDateTime localDateTime){
        ZonedDateTime atZone = localDateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: Date -> LocalDate
     */
    public static LocalDate getLocalDateFromDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: Date -> LocalDateTime
     */
    public static LocalDateTime getLocalDateTimeFromDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: String(pattern) -> Date
     */
    public static Date getDateFromStringOfPattern(String dateStr, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date parse = null;
        try {
            parse = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: String(yyyy-MM-dd) -> Date
     */
    public static Date getDateFromString(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: String(yyyy-MM-dd HH:mm:ss) -> Date
     */
    public static Date getDateTimeFromString(String dateStr){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: date -> string
     */
    public static String getStringFromDate(Date date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateStr = format.format(date);
        return dateStr;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 计算两个日期之间的天数
     */
    public static long diffTwoLocalDate(LocalDate localDate1, LocalDate localDate2){
        long diffDays = localDate1.toEpochDay() - localDate2.toEpochDay();
        if(diffDays < 0) diffDays = -(diffDays);
        return diffDays;
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 计算两个日期之间的天数
     */
    public static long diffTwoStringDate(String strDate1, String strDate2){
        LocalDate localDate1 = getLocalDateFromString(strDate1, "yyyy-MM-dd");
        LocalDate localDate2 = getLocalDateFromString(strDate2, "yyyy-MM-dd");
        return diffTwoLocalDate(localDate1, localDate2);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 计算两个日期之间的天数
     */
    public static long diffTwoDate(Date date1, Date date2){
        return diffTwoLocalDate(getLocalDateFromDate(date1), getLocalDateFromDate(date2));
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 获取指定日期的月初日期
     */
    public static LocalDate getFirstDayOfMonth(LocalDate localDate){
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: 获取指定日期的月末日期
     */
    public static LocalDate getLastDayOfMonth(LocalDate localDate){
        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * @author dongganen
     * @date 2019/7/25
     * @desc: string -> LocalDate(默认格式yyyy-MM-dd)
     */
    public static LocalDate getLocalDateFromString(String date){
        return LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(date));
    }

    /**
     * @author dongganen
     * @date 2019/7/25
     * @desc: string -> LocalDate(自定义格式)
     */
    public static LocalDate getLocalDateFromString(String date, String pattern){
        return LocalDate.from(DateTimeFormatter.ofPattern(pattern).parse(date));
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: LocalDate -> string(默认格式yyyy-MM-dd)
     */
    public static String getStringFromLocalDate(LocalDate localDate){
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * @author dongganen
     * @date 2019/7/26
     * @desc: LocalDate -> string(自定义格式)
     */
    public static String getStringFromLocalDate(LocalDate localDate, String pattern){
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }
}
