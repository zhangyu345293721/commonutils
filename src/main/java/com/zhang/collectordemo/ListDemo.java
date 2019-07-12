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
        /* Map<String, Person> personMap = list.stream().filter(e -> (e.getName() != null)).collect(Collectors.toMap(Person::getName, e -> e));
        System.out.println(personMap);
        System.out.println(personMap.get(null));
        // 从map中添加数据
        // System.out.println(personMap.get(2).getName());
        // Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        // map.put(4, "zhangyu");
        // System.out.println(map);
        List<Person> newList = list.stream().filter(e -> (e.getName() != null)).collect(Collectors.toList());
        System.out.println(newList);*/
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        // System.out.println(map.get(name).get(0).getName());
        map.keySet().stream().mapToLong(name -> name + map.get(name)).forEach(System.out::println);
    }

    @Test
    public void fun2() {
        List<Person> list = new ArrayList();
        list.add(new Person(1, "zhangsan"));
        list.add(new Person(2, "lisi"));
        list.add(new Person(3, "lisi"));
        list.add(new Person(3, "wangwu"));
        list.add(new Person(4, null));

        Map<String, Double> map = list.stream().filter(e -> (e.getName() != null)).collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getId)));
        for (String name : map.keySet()) {
            // System.out.println(map.get(name).get(0).getName());
            System.out.println(name + ":" + map.get(name));
        }
    }
}
