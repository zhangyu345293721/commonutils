package com.function.date;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间
 *
 * @author: zhangyu
 */
public class TestTime {
    /**
     * @param time time
     * @return 返回长整型数
     */
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

    /**
     * @param d 传入字符串
     * @return 返回长整型数
     */
    public Long getLongTimeMillisFromDateStr(String d) {
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
            date = formatter.parse(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 将long类型毫秒数转成固定格式字符串
     *
     * @param time time
     * @return 返回字符串
     */
    private String getFixFormatDate(long time) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
        return formatter.format(time);
    }

    @Test
    public void fixFormatDateDemo() {
        long startTime = 1559318400000l;
        System.out.println(getFixFormatDate(startTime));
    }

    @Test
    public void longTimeMillisFromDateStrDemo() {
        String d = "2019060100";
        long timeMillis = getLongTimeMillisFromDateStr(d);
        System.out.println(timeMillis);
    }

    @Test
    public void timeMillisFromDate() {
        // 将时间换成毫秒值
        String time = "2019-06-01 00:00:00";
        long timeMillis = getTimeMillis(time);
        System.out.println(timeMillis);
    }

    @Test
    public void fun() {
        System.out.println("\\n");
    }

}
