package com.zhang.collectordemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description: 测试ListDemo
 * @author: zhangyu
 * @create: 2019-06-18 17:34
 */
public class ListDemo {

    @Test
    public void fun() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        // jdk8 将链表变成map的方法
        Map<Integer, Double> map = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.averagingInt(Integer::intValue)));
        // System.out.println(map.get(name).get(0).getName());
        //map.keySet().stream().mapToLong(name -> name + map.get(name)).forEach(System.out::println);
        System.out.println(map);
    }

    @Test
    public void fun2() {
        List<Person> list = new ArrayList();
        list.add(new Person(1, "zhangsan"));
        list.add(new Person(2, "lisi"));
        list.add(new Person(3, "lisi"));
        list.add(new Person(3, "wangwu"));
        list.add(new Person(4, null));

        Map<String, Double> map = list.stream().filter(e -> e.getName() != null).collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getId)));
        for (String name : map.keySet()) {
            System.out.println(name + ":" + map.get(name));
        }
    }

    @Test
    public void fun3() {
        List<Person> list = new ArrayList();
        list.add(new Person(1, "zhangsan"));
        list.add(new Person(2, "lisi"));
        list.add(new Person(4, "lisi"));
        list.add(new Person(5, "wangwu"));
        list.add(new Person(6, null));

        Map<Integer, Person> map = list.stream().collect(Collectors.toMap(Person::getId, e -> e));
        for (Integer id : map.keySet()) {
            System.out.println(id + ":" + map.get(id).toString());
        }
    }
}
