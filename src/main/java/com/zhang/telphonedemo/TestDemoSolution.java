package com.zhang.telphonedemo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: utilsdemo
 * @description:
 * @author: zhangyu
 * @create: 2019-01-20 19:16
 */
public class TestDemoSolution {
    @Test
    public void fun() {
        Solution solution1 = new Solution();

        Interval interval1 = new Interval();
        interval1.setStart(1);
        interval1.setEnd(2);

        Interval interval2 = new Interval();
        interval2.setStart(1);
        interval2.setEnd(3);

        LinkedList<Interval> list = new LinkedList<>();
        list.add(interval1);
        list.add(interval2);
        List<Interval> newList = solution1.merge(list);

        System.out.println(newList);

    }
}
