package com.algo.telphonedemo;

import org.junit.jupiter.api.Test;

/**
 * @program: utilsdemo
 * @description: 找出一个手机号下包含8888的个数
 * @author: zhangyu
 * @create: 2019-05-07 17:56
 */
public class TelephoneDemo {
    @Test
    public void fun() {
        int count = 0;
        long time1 = System.currentTimeMillis();
        for (long i = 13500000000l; i <= 13599999999l; i++) {
            String number = String.valueOf(i);
            if (number.contains("8888"))
                count++;
        }
        long time2 = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(time2 - time1);
    }

    @Test
    public void fun2() {
        int count = 0;
        long time1 = System.currentTimeMillis();
        for (long i = 13500000000l; i <= 13599999999l; i++) {
            StringBuffer number = new StringBuffer();
            number.append(i);
            if (number.toString().contains("8888"))
                count++;
        }
        long time2 = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(time2 - time1);
    }
}
