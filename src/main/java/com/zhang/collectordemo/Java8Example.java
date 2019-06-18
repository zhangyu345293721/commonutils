package com.zhang.collectordemo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: utilsdemo
 * @description: 测试函数式编程
 * @author: zhangyu
 * @create: 2019-06-18 14:55
 */
public class Java8Example {
    @Test
    public void fun() {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(result);
    }

    @Test
    public void fun2() {
        List<Integer> s = Arrays.asList(1, 2, 3, 4);
        // s.map(x->x*2).forEach(System.out::print);
        s.stream().mapToInt(x -> x).forEach(System.out::print);
        System.out.println();
        // double变成int可以用Double的intValue的类
        Double sum = s.stream().mapToDouble(x -> x).sum();
        System.out.println(sum.intValue());
    }
}
