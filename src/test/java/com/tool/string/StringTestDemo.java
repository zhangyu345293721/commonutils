package com.tool.string;

import com.tool.base.stream.IntUtils;
import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Combination;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    @Test
    public void combinationTestDemo() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));
        Combination<Integer> combination = Combination.of(list, 2);
        List<List<Integer>> allList = new ArrayList<>();
        combination.forEach(e -> allList.add(new ArrayList<>(e)));
        System.out.println(allList.size());
    }

    @Test
    public void stringJoinDemo() {
        String[] s = {"a", "b", "c", "d", "e"};
        String joinStr = String.join("", s);
        System.out.println(joinStr);
    }

    @Test
    public void stringJoinStreamDemo2() {
        int[] s = {1, 2, 3, 4, 5, 6, 7};
        String collect = Arrays.stream(s).boxed().map(e -> String.valueOf(e)).collect(Collectors.joining(""));
        System.out.println(collect);
    }

    @Test
    public void stringJoinStreamDemo3() {
        String str = "12345";
        int[] arrays = IntUtils.string2IntArrays(str);
        for (int num : arrays) {
            System.out.println(num);
        }
    }
}


