package com.tool.function.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: utilsdemo
 * @description: date时间变成毫秒值
 * @author: zhangyu
 */
public class DateToTime {
    @Test
    public void fun() {
        Calendar calendar = Calendar.getInstance();
        //需要注意一下,calendar传入的月份,是从0开始计数的(也就是说,2月相当于实际的三月)
        calendar.set(2019, 6, 1, 1, 0, 0);
        long time = calendar.getTimeInMillis();
        System.out.println(time);
        long shortTime = getWholeHourTimeMillis(time);
        System.out.println(shortTime);
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

    /**
     * 把时间转成毫秒值    2019-09-27 15:18:48:310
     *
     * @param date 时间参数
     * @return 返回长整型13位毫秒数
     */
    public static long getLongTime(String date) {
        long time = -1;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            time = simpleDateFormat.parse(date).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 将毫秒值转成日期时间    2019-09-27 15:18:48:310
     *
     * @param time 时间参数
     * @return 返回长整型13位毫秒数
     */
    public static String getDateTime(long time) {
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        return String.valueOf(sdf.format(d));
    }

}
