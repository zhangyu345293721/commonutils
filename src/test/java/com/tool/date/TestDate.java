package com.tool.date;

import com.tool.base.date.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zhangyu
 */
public class TestDate {

    @Test
    public void getTimeMillis() throws Exception {

        long milliSecond = 1569859200000l;
        Date date = new Date();
        date.setTime(milliSecond);
        String str = new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(str);
        long time2 = new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
        System.out.println(time2);
    }

    @Test
    public void getDateString() {
        String dateString = getMonthPath(1571120135000L, 1571123735000L);
        System.out.println(dateString);
    }

    public String getMonthPath(long startTime, long endTime) {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM");
        String sb = format.format(startTime);
        return sb;
    }

    public long getMillisTime(String d) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        long millis = date.getTime();
        return millis;
    }


    @Test
    public void DateUtilsTestDemo() {
        Date time=DateUtils.string2Date("2019-10-19", "yyyy-MM-dd");
        System.out.println(time.getTime());
    }
}
