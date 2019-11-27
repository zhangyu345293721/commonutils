package com.tool.function.stream;

import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Permutation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zhangyu
 */
public class ListDemo {

    @Test
    public void permutationTestDemo() {
        List<List<String>> newList = new ArrayList<>();
        for (List<String> list : Permutation.of(Arrays.asList("a", "b", "c"))) {
            newList.add(new ArrayList<>(list));
        }
        System.out.println(newList);
    }

    @Test
    public void permutationTestDemo2() {
        System.out.println(Permutation.of(Arrays.asList("a", "b", "c"), 3).iterator());
        Iterator iter = Permutation.of(Arrays.asList("a", "b", "c"), 3).iterator();
        List<List<String>> list = new ArrayList<>();
        BigInteger b = Permutation.of(Arrays.asList("a", "b", "c")).getPermutationCount();
        //System.out.println(b);
        while (iter.hasNext()) {
            List<String> oneList = (List<String>) iter.next();
            System.out.println(list.add(oneList));
        }
        System.out.println(list);
    }

    // 双重过滤，过滤掉为空和null的字符串
    @Test
    public void filterTestDemo() {
        List<String> list = new ArrayList<>(Arrays.asList(null, "", "12", "34"));
        List<String> list2 = list.stream().filter(e -> e != null).filter(e -> e.length() > 0).collect(Collectors.toList());
        System.out.println(list2);
    }

    @Test
    public void stringDistinctTestDemo() {
        List<String> list = Arrays.asList("Hello", "World");
        List<String[]> newList = list.stream().map(word -> word.split("")).distinct().collect(Collectors.toList());
        newList.stream().forEach(e -> System.out.println(e[0]));
    }

    @Test
    public void mapTestFlatMapTestDemo() {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world", "hello world welcome");
        // map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

    }

    @Test
    public void flatMapTestDemo() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> figures = Stream.of(a, b).flatMap(u -> u.stream()).collect(Collectors.toList());
        figures.forEach(f -> System.out.print(f + " "));
    }

    @Test
    public void flatMapTestDemo2() {
        List<String> words = new ArrayList();
        words.add("hello");
        words.add("word");

        // 将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        // 如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(stringList);
    }

    @Test
    public void mapTestDemo2() {
        List<String> words = new ArrayList();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到[h, e, l, l, o][w, o, r, d]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String[]> stringList = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.print(Arrays.toString(e)));
    }

    /**
     * 将字符串转成字符流
     *
     * @param s 输入字符串
     * @return 输出流
     */
    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }
}
