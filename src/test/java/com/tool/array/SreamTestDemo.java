package com.tool.array;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream流操作
 *
 * @author: zhangyu
 */
public class SreamTestDemo {
    /**
     * 合并两个流
     */
    @Test
    public void streamTestDemo() {
        Stream<Integer> list1 = Stream.of(1, 2, 3);
        Stream<Integer> list2 = Stream.of(4, 5, 6);
        List<Integer> list = Stream.concat(list1, list2).collect(Collectors.toList());
        list.stream().forEach(e -> System.out.print(e + " "));
    }

    @Test
    public void streamToListTestDemo() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        collected.stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void streamToUpperListTestDemo() {
        List<String> collected = Stream.of("a", "b", "c").map(e -> e.toUpperCase()).collect(Collectors.toList());
        collected.stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void streamSelectTestDemo() {
        List<String> beginningWithNumbers = Stream.of("a", "1bc", "1abc1").
                filter(value -> Character.isDigit(value.charAt(0))).
                collect(Collectors.toList());
        beginningWithNumbers.stream().forEach(e -> System.out.print(e + " "));
    }

    @Test
    public void firstToUpperTestDemo() {
        Stream<String> strs = Stream.of("abc", "bcd", "efg");
        List<String> list = strs.map(e -> e.substring(0, 1).toUpperCase() + e.substring(1)).collect(Collectors.toList());
        list.stream().forEach(e -> System.out.print(e + " "));
    }

    @Test
    public void flatMapTestDemo() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(n -> n.stream())
                .collect(Collectors.toList());

        together.stream().forEach(e -> System.out.print(e + " "));
    }

    @Test
    public void reduceTestDemo() {
        int count = Stream.of(1, 2, 3).mapToInt(e -> e).sum();
        // int count = Stream.of(1, 2, 3).reduce(0, (x, y) -> x + y);
        System.out.println(count);
    }

    @Test
    public void flatMapTestDemo2() {
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        List<String> list = Stream.of(data).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());
        System.out.println(list);
    }

    // 使用join对字符串进行拼接
    @Test
    public void personTestDemo() {
        Person p1 = new Person("zhangyu", "123456", 12);
        Person p2 = new Person("tangtuo", "334", 24);
        Person p3 = new Person("lisi", "wangwu", 25);
        List<Person> artists = Arrays.asList(p1, p2, p3);
        String result = artists.stream().map(Person::getUserName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);
    }

    @Test
    public void parallelDiceRollsTestDemo() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int totalSum = addInteger(list);
        System.out.println("totalSum = " + totalSum);
        double average = list.parallelStream().mapToInt(e -> e).summaryStatistics().getAverage();
        System.out.println(average);
        long totalPowSum = list.stream().mapToInt(e -> e).map(x -> x * x).summaryStatistics().getSum();
        System.out.println("totalPowSum = " + totalPowSum);
    }

    @Test
    public void testSystem() {
        System.out.println(String.format("Hi,%s,知道我吗!", "王力"));
        System.out.println(String.format("Hi,%d,知道我吗!", 10));
        System.out.println(String.format("Hi,%f,知道我吗!", 10.0f));
    }

    public int addInteger(List<Integer> values) {
        return values.parallelStream().mapToInt(i -> i).sum();
    }
}