package com.zhang.computetime;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 统计出现次数
 *
 * @author: zhangyu
 */
public class DemoStatistic {

    @Test
    public void fun() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 2, 3, 1));

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
