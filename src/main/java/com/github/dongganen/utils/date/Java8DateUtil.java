package com.github.dongganen.utils.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Java8DateUtil {

    /**
     * localDate -> Date
     * @param localDate
     * @return
     */
    public static Date returnDate(LocalDate localDate){
        ZonedDateTime atZone = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    /**
     * LocalDateTime -> Date
     * @param localDateTime
     * @return
     */
    public static Date returnDate(LocalDateTime localDateTime){
        ZonedDateTime atZone = localDateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    /**
     * Date -> LocalDate
     * @param date
     * @return
     */
    public static LocalDate returnLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    /**
     * Date -> LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime returnLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * 格式化LocalDateTime
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String formatterLocalDateTime(LocalDateTime localDateTime, String pattern){
        String format = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        return format;
    }

    /**
     * 格式化LocalDate
     * @param localDate
     * @param pattern
     * @return
     */
    public static String formatterLocalDateTime(LocalDate localDate, String pattern){
        String format = localDate.format(DateTimeFormatter.ofPattern(pattern));
        return format;
    }
}
