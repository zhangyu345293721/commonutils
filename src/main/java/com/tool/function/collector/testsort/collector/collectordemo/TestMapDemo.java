package com.tool.function.collector.testsort.collector.collectordemo;

/**
 * @program: utilsdemo
 * @description: 测试map
 * @author: zhangyu
 * @create: 2019-06-18 14:08
 */

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMapDemo {

    @Test
    public void fun() {
        List<Person> list = new ArrayList();
        list.add(new Person("zhangsan","12",12));

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
        Map<String, Long> map = list.stream().filter(e -> (e.getUserName() != null)).collect(Collectors.groupingBy(Person::getUserName,Collectors.counting()));
        for (String name : map.keySet()) {
            // System.out.println(map.get(name).get(0).getName());
            System.out.println(name + map.get(name));
        }
    }
}

