package com.tool.function.jdk8demo;

import com.tool.bean.TestObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangyu
 */
public class StreamOperation {

    List<TestObject> list = Arrays.asList(
            new TestObject("Ron", "M", 10, "ron.zheng@tfschange.com", false),
            new TestObject("KDS", "W", 10, "kds@qq.com", false),
            new TestObject("BoDuo", "W", 30, "boduo@163.com", false),
            new TestObject("CangJin", "W", 10, "cangjin@gmail.com", false),
            new TestObject("XiaoZe", "W", 30, "xiaoze@hotmail.com", true),
            new TestObject("James", "M", 10, "leblonjames@hotmail.com", true),
            new TestObject("Allen", "M", 50, "allen.lei@tfschange.com", true),
            new TestObject("Smith", "M", 9, "jr.smith@cel.com", true),
            new TestObject("Wade", "M", 20, "dw.wade@cel.com", true),
            new TestObject("Wade", "M", 20, "dw.wade@cel.com", false)
    );

    // 测试filter
    @Test
    public void fun1() {
        List<TestObject> arrList = list.stream().filter(TestObject::getFlag).collect(Collectors.toList());
        arrList.stream().forEach((e -> System.out.println(e.getName())));
    }

    // 测试distinct
    @Test
    public void fun2() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    // 测试limit
    @Test
    public void fun3() {
        list.stream().filter(u -> u.getSex().equalsIgnoreCase("w")).limit(5).forEach(u -> System.out.println(u.getName()));
    }

    // 测试toList
    @Test
    public void fun4() {
        list.stream().map(TestObject::getName).collect(Collectors.toList()).forEach(System.out::println);
    }

    // 打印数组的长度
    @Test
    public void fun5() {
        list.stream()
                .map(TestObject::getName)
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // 测试anyMatch
    @Test
    public void fun6() {
        if (list.stream().anyMatch(u -> u.getName().equals("Ron"))) {
            System.out.println("Ron已经到了");
        }
    }

    // 测试allMatch
    @Test
    public void fun7() {
        if (list.stream().allMatch(u -> u.getAge() >= 10)) {
            System.out.println("很棒，都大于10岁");
        } else {
            System.out.println("原来都还没发育");
        }
    }

    // 测试findAny
    @Test
    public void fun8() {
        list.stream()
                .filter(u -> u.getName().equals("Ron"))
                .findAny()
                .ifPresent(u -> System.out.println(u.getAge()));
    }

    // 测试findFirst
    @Test
    public void fun9() {
        list.stream()
                .filter(u -> u.getFlag())
                .findFirst()
                .ifPresent(u -> System.out.println(u.getName()));
    }
}
