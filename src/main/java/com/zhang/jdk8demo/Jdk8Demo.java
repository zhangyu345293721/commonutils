package com.zhang.jdk8demo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description: 测试jdk8的新特性
 * @author: zhangyu
 * @create: 2019-05-28 15:00
 */
public class Jdk8Demo {
    @Test
    public void fun1() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void fun2() {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1);
    }

    // 测试set集合
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
}
