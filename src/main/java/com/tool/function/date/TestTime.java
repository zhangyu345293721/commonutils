package com.tool.function.date;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: utilsdemo
 * @description: 测试时间
 * @author: zhangyu
 * @create: 2019-06-12 14:57
 */
public class TestTime {

    @Test
    public void fun() {
        /*
        long l = new Date().getTime();
        System.out.println(String.valueOf(l).length());
        */
        // 将时间换成毫秒值
        String time = "2019-06-01 00:00:00";
        long timeMillis = getTimeMillis(time);
        System.out.println(timeMillis);
        //System.out.println(String.valueOf(timeMillis).length());
    }

    public long getTimeMillis(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeMillis = -1;
        try {
            Date date = format.parse(time);
            timeMillis = date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeMillis;
    }

    @Test
    public void fun2() {
        Long timeMillis = 1559322000000l;
        System.out.println(timeMillis);

    }

    @Test
    public void fun3() {
        long startTime = 1559318400000l;
        long endTime = 1559322000000l;
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
        System.out.println(formatter.format(startTime));
        System.out.println(formatter.format(endTime));

    }

    @Test
    public void fun4() {
        String d = "2019060100";
        long timeMillis = getLongTimeMillis(d);
        System.out.println(timeMillis);
    }

    public Long getLongTimeMillis(String d) {
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
            date = formatter.parse(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
