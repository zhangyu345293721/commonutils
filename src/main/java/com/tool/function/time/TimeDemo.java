package com.tool.function.time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.SECONDS;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * 使用jdk8的time类
 *
 * @author: zhangyu
 */

public class TimeDemo {
    @Test
    public void localDateTestDemo() {
        LocalDate date = LocalDate.of(2019, 10, 30);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth(); // 一个月的长度
        boolean leap = date.isLeapYear();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dow);
        System.out.println(len);
        System.out.println(leap);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        int year1 = date.get(ChronoField.YEAR);
        System.out.println(year1);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month1);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day1);
    }

    @Test
    public void localTimeTestDemo() {
        LocalTime time = LocalTime.of(17, 45, 32);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
    }

    @Test
    public void LocalDateTimeTestDemo() {
        LocalDateTime dt1 = LocalDateTime.of(2014, 3, 12, 13, 45, 20);
        // LocalDateTime dt2=LocalDateTime.of(date,time)
        System.out.println(dt1.getDayOfWeek());
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(date1.getMonth().getValue());
        System.out.println(time1.getHour());
    }

    @Test
    public void priodTestDemo() {
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
        System.out.println(tenDays.getDays());
    }

    @Test
    public void durationTestDemo() {
        Duration time = Duration.between(LocalDateTime.of(2014, 3, 12, 13, 45, 20), LocalDateTime.of(2019, 3, 12, 13, 45, 20));
        System.out.println(time.get(SECONDS));
    }

    @Test
    public void modifyLocalTestDemo() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.withMonth(10);
        System.out.println(date4.toString());
    }

    @Test
    public void LocalDateTestDemo() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.plusWeeks(1);
        System.out.println(date1);
        System.out.println(date2);
        LocalDate date3 = date2.minusYears(3);
        System.out.println(date3);
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);
        LocalDate date5 = date4.plusYears(1);
        System.out.println(date4);
        System.out.println(date5);
    }

    @Test
    public void LocalDateTestDemo2() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        date = date.plusYears(2).minusDays(10);
        date.withYear(2011);
        System.out.println(date);
    }

    @Test
    public void LocalDateTestDemo3() {
        LocalDate date1 = LocalDate.of(2015, 3, 18);
        System.out.println(date1);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date2);
        LocalDate date3 = date2.with(lastDayOfMonth());
        System.out.println(date3);
        LocalDate date4 = date3.with(lastDayOfYear());
        System.out.println(date4);
    }

    // 注意细节，注意溢出操作
    @Test
    public void forTestDemo() {
        int start = Integer.MAX_VALUE - 100;
        int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i < end; i++) {
            count++;
        }
        System.out.println(count);
    }
}
