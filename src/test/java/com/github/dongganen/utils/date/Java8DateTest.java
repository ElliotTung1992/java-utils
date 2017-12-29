package com.github.dongganen.utils.date;



import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Java8DateTest {

    @Test
    public void testReturnDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
        Date date = DateUtils.transformLocalDateToDate(now);
        System.out.println(date);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        Date date1 = DateUtils.transformLocalDateTimeToDate(now1);
        System.out.println(date1);

    }

    @Test
    public void returnLocalDate(){
        LocalDate localDate = DateUtils.transformDateToLocalDate(new Date());
        System.out.println(localDate);
    }

    @Test
    public void returnLocalDateTime(){
        LocalDateTime localDateTime = DateUtils.transformDateToLocalDateTime(new Date());
        System.out.println(localDateTime);
    }

    @Test
    public void transformStringToDate(){
        Date date = DateUtils.transformStringToDate("2019-09-08", "yyyy-MM-dd");
        System.out.println(date);
        Date date1 = DateUtils.transformStringToDate("2018-08-09 20:20:20", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date1);
    }

    @Test
    public void transformDateToString(){
        String s = DateUtils.transformDateToString(new Date(), "yyyy-MM-dd");
        System.out.println(s);
        String s1 = DateUtils.transformDateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(s1);
    }

    @Test
    public void daysBetweenTwoDate(){
        int i = DateUtils.daysBetweenTwoDate("2018-01-01", "2017-12-29");
        System.out.println(i);
    }
}
