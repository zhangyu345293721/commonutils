package com.tool.function.collector.jdk8demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试jdk8的新特性
 * @author: zhangyu
 */
public class StreamTest {
    // 将小写字母变成大写字母
    @Test
    public void fun1() {
        List<String> list = Arrays.asList("a", "b", "c", "d"); //使用asLit之后，不能再加入新的元素
        // list.add("f");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.add("f");
        System.out.println(collect);
    }

    // 对list中的每个元素进行map操作
    @Test
    public void fun2() {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> collect1 = num.stream().map(n -> Math.pow(n, 2)).collect(Collectors.toList());
        // 对collect1进行操作
        System.out.println(collect1);
    }

    // 把set集合转成list
    @Test
    public void fun3() {
        Set<Integer> num = new HashSet<>();
        num.add(1);
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(3);
        List list = num.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    // 过滤掉字符串中为空
    @Test
    public void fun4() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(t -> !t.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
    }

    // 测试sorted进行排序后再打印
    @Test
    public void fun6() {
        Random random = new Random(1);
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    // 统计不为空的个数
    @Test
    public void fun7() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        long count = strings.stream().filter(t -> t.isEmpty()).count();
        System.out.println(count);
    }

    // 统计出现次数
    @Test
    public void fun8() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.toList());
        // 过滤掉为空的字符串
        System.out.println(filtered);
        // 对字符串进行拼接
        String mergeString = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.joining(" "));
        System.out.println(mergeString);
    }

    // stream的统计流计算
    @Test
    public void fun9() {
        List<Integer> numbers = Arrays.asList(3, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

        // 获取最大值
        int max = numbers.stream().mapToInt((x) -> x).summaryStatistics().getMax();
        System.out.println(max);
    }

    @Test
    public void fun10() {
        double d1 = 1.0;
        double d2 = 1.000;
        System.out.println(d1 == d2);

        System.out.println((int) 1.2);

        Double d = 1.3;
        System.out.println(d.intValue());
    }
}
