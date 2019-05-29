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
    // 将小写字母变成大写字母
    @Test
    public void fun1() {
        List<String> list = Arrays.asList("a", "b", "c", "d"); //使用asLit之后，不能再加入新的元素
        // list.add("f");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.add("f");
        System.out.println(collect);
    }

    @Test
    public void fun2() {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> collect1 = num.stream().map(n -> Math.pow(n,2)).collect(Collectors.toList());
        // 对collect1进行操作
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
