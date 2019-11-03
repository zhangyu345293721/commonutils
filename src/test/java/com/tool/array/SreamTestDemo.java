package com.tool.array;

import org.junit.jupiter.api.Test;

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
}