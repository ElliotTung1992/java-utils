package com.github.dge1992.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class DateUtil {

    /**
     * localDate -> Date
     * @param localDate
     * @return
     */
    public static Date transformLocalDateToDate(LocalDate localDate){
        ZonedDateTime atZone = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    /**
     * LocalDateTime -> Date
     * @param localDateTime
     * @return
     */
    public static Date transformLocalDateTimeToDate(LocalDateTime localDateTime){
        ZonedDateTime atZone = localDateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(atZone.toInstant());
        return date;
    }

    /**
     * Date -> LocalDate
     * @param date
     * @return
     */
    public static LocalDate transformDateToLocalDate(Date date){
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
    public static LocalDateTime transformDateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * String(pattern) -> Date
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date transformStringToDate(String dateStr, String pattern){
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
     * date -> string
     * @param date
     * @param pattern
     * @return
     */
    public static String transformDateToString(Date date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateStr = format.format(date);
        return dateStr;
    }

    /**
     * 计算两个日期之间的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int diffTwoDate(Date date1, Date date2){
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        int days = 0;
        if(date1.after(date2)){
            days = (int)(time1 - time2)/(24 * 60 * 60 * 1000);
        }else{
            days = (int)(time2 - time1)/(24 * 60 * 60 * 1000);
        }
        return days;
    }

    /**
     * 计算两个日期之间的天数
     * @param strDate1
     * @param strDate2
     * @return
     */
    public static int diffTwoDate(String strDate1, String strDate2){
        Date date1 = DateUtil.transformStringToDate(strDate1, "yyyy-MM-dd");
        Date date2 = DateUtil.transformStringToDate(strDate2, "yyyy-MM-dd");
        return DateUtil.diffTwoDate(date1, date2);
    }
}
