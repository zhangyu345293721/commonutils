package com.zhang.date;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: utilsdemo
 * @description: date时间变成毫秒值
 * @author: zhangyu
 * @create: 2019-07-08 16:55
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
}
