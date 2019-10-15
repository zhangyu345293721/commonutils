package com.tool.function.collector.testsort.collector.collectordemo;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description: 测试函数式编程
 * @author: zhangyu
 * @create: 2019-06-18 14:55
 */

public class StreamDemo {
    /**
    *@Description: 统计一个字符出现的个数，利用jdk8的新特性
    *@Author: zhangyu
    */
    @Test
    public void fun() {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(result);
    }

    @Test
    public void fun4() {
        List<Integer> s = Arrays.asList(-1, -2, -3, -4);
        // s.map(x->x*2).forEach(System.out::print);
        // s.stream().mapToInt(x -> x).forEach(System.out::print);
        // System.out.println();
        // double变成int可以用Double的intValue的类
        int max = s.stream().mapToInt(x -> x).max().orElse(0);
        System.out.println(max);
    }

    @Test
    public void fun5() {
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        System.out.println(updateTime.getTime());
        //Thread.sleep(10);
        System.out.println(System.currentTimeMillis());
    }

    //毫秒值变成
    @Test
    public void fun6() {
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        System.out.println(updateTime.getTime());
        Long wholeHourTimeMillis = getWholeHourTimeMillis(updateTime.getTime());
        System.out.println(wholeHourTimeMillis);
        // 将时间变成日期形式
    }

    public static long getWholeHourTimeMillis(Long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        String dateStr = dateFormat.format(time);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
            // System.out.println(date.getTime());
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
