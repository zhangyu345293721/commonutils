package com.zhang.collectordemo;

/**
 * @program: utilsdemo
 * @description: 测试map
 * @author: zhangyu
 * @create: 2019-06-18 14:08
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMapDemo {

    @Test
    public void fun() {
        List<Person> list = new ArrayList();
        list.add(new Person(1, "zhangsan"));
        list.add(new Person(2, "lisi"));
        list.add(new Person(3, "wangwu"));
        // jdk8将链表变成map的方法
        Map<Integer, Person> personMap = list.stream().collect(Collectors.toMap(Person::getId, e -> e));
        System.out.println(personMap);
        System.out.println(personMap.get(1));
        // 从map中添加数据
        System.out.println(personMap.get(2).getName());
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        map.put(4, "zhangyu");
        System.out.println(map);
    }
}

