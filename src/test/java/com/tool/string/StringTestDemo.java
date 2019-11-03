package com.tool.string;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

/**
 * 测试字符串操作
 *
 * @author: zhangyu
 */
public class StringTestDemo {
    @Test
    public void joinTestDemo() {
        String s = String.join("_", "I", "love", "china");
        System.out.println(s);

    }

    @Test
    public void lambdaTestDemo() {
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(6));
        System.out.println(atLeast5.test(5));
    }

    @Test
    public void getNowTime() {
        long d = new Date().getTime();
        System.out.println(d);
    }

    @Test
    public void getLongTimeTestDeme() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        String time2 = "2018092916";
        Date date = format.parse(time2);
        //日期转时间戳（毫秒）
        long time = date.getTime();
        System.out.print("Format To times:" + time);
    }

    @Test
    public void getDateFromLongTime() {
        //impleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 15727680000000l;
        Date date = new Date(time);
        System.out.println(date);

    }
}
