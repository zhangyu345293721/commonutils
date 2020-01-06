package com.function.collector.testsort.collector.collectordemo;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 测试ListDemo
 * @author: zhangyu
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
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));

        Map<String, Double> map = list.stream().filter(e -> e.getUserName() != null).collect(Collectors.groupingBy(Person::getUserName, Collectors.averagingInt(Person::getAge)));
        for (String name : map.keySet()) {
            System.out.println(name + ":" + map.get(name));
        }
    }

    @Test
    public void fun3() {
        List<Person> list = new ArrayList();
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 12));

        Map<Integer, Person> map = list.stream().collect(Collectors.toMap(Person::getAge, e -> e));
        for (Integer id : map.keySet()) {
            System.out.println(id + ":" + map.get(id).toString());
        }
    }
}
