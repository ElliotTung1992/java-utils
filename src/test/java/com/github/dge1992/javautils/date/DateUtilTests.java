package com.github.dge1992.javautils.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateUtilTests {

	@Test
	public void contextLoads() {

	}

    @Test
	public void getDateParseString(){
        LocalDate localDate = DateUtil.getLocalDateFromString("2019-06-26");
        System.out.println(localDate);
    }

    @Test
    public void getDateParseString2(){
        LocalDate localDate = DateUtil.getLocalDateFromString("2019/06/26", "yyyy/MM/dd");
        System.out.println(localDate);
    }

    @Test
    public void getStringFromLocalDate2(){
        String localDateOfPattern = DateUtil.getStringFromLocalDate(LocalDate.now());
        System.out.println(localDateOfPattern);
    }

    @Test
    public void getStringFromLocalDate(){
        String localDateOfPattern = DateUtil.getStringFromLocalDate(LocalDate.now(), "yyyy/MM/dd");
        System.out.println(localDateOfPattern);
    }

    @Test
    public void getFirstDayOfMonth(){
        LocalDate firstDayOfMonth = DateUtil.getFirstDayOfMonth(LocalDate.now());
        System.out.println(firstDayOfMonth);
    }

    @Test
    public void getLastDayOfMonth(){
        LocalDate lastDayOfMonth = DateUtil.getLastDayOfMonth(LocalDate.now());
        System.out.println(lastDayOfMonth);
    }

    @Test
    public void getDateFromLocalDate(){
        Date dateFromLocalDate = DateUtil.getDateFromLocalDate(LocalDate.now());
        System.out.println(dateFromLocalDate);
    }

    @Test
    public void getDateFromLocalDateTime(){
        Date date = DateUtil.getDateFromLocalDateTime(LocalDateTime.now());
        System.out.println(date);
    }

    @Test
    public void getLocalDateFromDate(){
        LocalDate localDateFromDate = DateUtil.getLocalDateFromDate(new Date());
        System.out.println(localDateFromDate);
    }

    @Test
    public void getLocalDateTimeFromDate(){
        LocalDateTime localDateTimeFromDate = DateUtil.getLocalDateTimeFromDate(new Date());
        System.out.println(localDateTimeFromDate);
    }

    @Test
    public void getDateFromStringOfPattern(){
        Date date = DateUtil.getDateFromStringOfPattern("2019-06-05", "yyyy-MM-dd");
        System.out.println(date);
    }

    @Test
    public void getDateFromString(){
        Date dateFromString = DateUtil.getDateFromString("2019-06-05");
        System.out.println(dateFromString);
    }

    @Test
    public void getDateTimeFromString(){
        Date dateFromString = DateUtil.getDateTimeFromString("2019-06-05 20:18:35");
        System.out.println(dateFromString);
    }

    @Test
    public void getStringFromDate(){
        String stringFromDate = DateUtil.getStringFromDate(new Date(), "yyyy-MM-dd");
        System.out.println(stringFromDate);
    }

    @Test
    public void diffTwoLocalDate(){
        long l = DateUtil.diffTwoLocalDate(LocalDate.of(2019, 7, 25), LocalDate.now());
        System.out.println(l);
        long l2 = DateUtil.diffTwoLocalDate(LocalDate.now(), LocalDate.of(2019, 7, 25));
        System.out.println(l2);
    }

    @Test
    public void diffTwoStringDate(){
        long l = DateUtil.diffTwoStringDate("2019-07-25", "2019-07-21");
        System.out.println(l);
        long l2 = DateUtil.diffTwoStringDate("2019-07-21", "2019-07-25");
        System.out.println(l2);
    }

    @Test
    public void diffTwoDate(){
        long l = DateUtil.diffTwoDate(new Date(2019, 7, 26), new Date(2019, 7, 20));
        System.out.println(l);
        long l2 = DateUtil.diffTwoDate(new Date(2019, 6, 20), new Date());
        System.out.println(l2);
        System.out.println(new Date(2019, 6, 26));
        System.out.println(new Date());
    }
}
