package com.tool.function.time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * 使用jdk8的time类
 *
 * @author: zhangyu
 */

public class TimeDemo {
    // jdk8的localDate
    @Test
    public void localDateTestDemo() {
        LocalDate date = LocalDate.of(2019, 10, 30);
        int year = date.getYear();
        System.out.println(year);
        Month month = date.getMonth();
        System.out.println(month);
        int day = date.getDayOfMonth();
        System.out.println(day);
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println(dow);
        // 一个月的长度
        int len = date.lengthOfMonth();
        System.out.println(len);
        boolean leap = date.isLeapYear();
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

    // jdk8的localTime
    @Test
    public void localTimeTestDemo() {
        LocalTime time = LocalTime.of(17, 45, 32);
        int hour = time.getHour();
        System.out.println(hour);
        int minute = time.getMinute();
        System.out.println(minute);
        int second = time.getSecond();
        System.out.println(second);
    }

    @Test
    public void localTimeTestDemo2() {
        LocalTime time = LocalTime.now();
        // 获取小时
        int hour = time.getHour();
        System.out.println(hour);
        // 获取分钟
        int minute = time.getMinute();
        System.out.println(minute);
        // 获取秒
        int second = time.getSecond();
        System.out.println(second);
    }

    // jdk8测试localDataTime
    @Test
    public void LocalDateTimeTestDemo() {
        LocalDateTime dt1 = LocalDateTime.of(2014, 3, 12, 13, 45, 20);
        System.out.println(dt1.getDayOfWeek());
        // 获取localDate
        LocalDate date1 = dt1.toLocalDate();
        // 获取LocalTime
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(date1.getMonth().getValue());
        System.out.println(time1.getHour());
    }

    // jdk8的priod,直接计算间隔多少天
    @Test
    public void priodTestDemo() {
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
        System.out.println(tenDays.getDays());
    }

    // 间隔多少秒
    @Test
    public void durationTestDemo() {
        Duration time = Duration.between(LocalDateTime.of(2014, 3, 12, 13, 45, 20), LocalDateTime.of(2019, 3, 12, 13, 45, 20));
        System.out.println(time.getSeconds());
    }

    // 可以修改时间类
    @Test
    public void modifyLocalTestDemo() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.withMonth(10);
        System.out.println(date4.toString());
    }

    // localTime平移操作
    @Test
    public void localDateTest() {
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
        LocalDate localDate = date.withYear(2011);
        System.out.println(localDate);
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
