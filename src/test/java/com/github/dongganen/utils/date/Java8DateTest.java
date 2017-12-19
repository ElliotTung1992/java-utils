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
        Date date = Java8DateUtil.returnDate(now);
        System.out.println(date);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);
        Date date1 = Java8DateUtil.returnDate(now1);
        System.out.println(date1);

        String s = Java8DateUtil.formatterLocalDateTime(now1, "yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
    }

    @Test
    public void returnLocalDate(){
        LocalDate localDate = Java8DateUtil.returnLocalDate(new Date());
        System.out.println(localDate);
    }

    @Test
    public void returnLocalDateTime(){
        LocalDateTime localDateTime = Java8DateUtil.returnLocalDateTime(new Date());
        System.out.println(localDateTime);
    }

    @Test
    public void formatterLocalDateTime(){
        LocalDate now = LocalDate.now();
        String s = Java8DateUtil.formatterLocalDateTime(now, "yyyy-MM-dd");
        System.out.println(now);
        System.out.println(s);
    }
}
