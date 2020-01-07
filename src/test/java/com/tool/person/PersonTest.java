package com.tool.person;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 测试person
 *
 * @author: zhangyu
 */
public class PersonTest {
    @Test
    public void personDemo() {
        Person p1 = new Person("zhang", "123", 12);
        Person p2 = new Person("zhang", "123", 24);
        Person p3 = new Person("zhang", "124", 25);
        Person p4 = new Person("zhang", "124", 26);
        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        savePerson(list);
    }

    /**
     * 泛型方法
     *
     * @param list 传入链表
     * @param <T>  传入参数
     */
    public <T> void savePerson(List<T> list) {
        for (T t : list) {
            if (t instanceof Person) {
                Person person = (Person) t;
                System.out.println(person.toString());
            }
        }
    }

    @Test
    public void personDemo2() {
        Person p1 = new Person("zhang", "123", 12);
        Person p2 = new Person("zhang", "123", 24);
        Person p3 = new Person("zhang", "124", 25);
        Person p4 = new Person("zhang", "124", 26);
        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(e -> e.getPassword()));
        List<Person> collect1 = collect.entrySet().stream().map(e ->
                e.getValue().stream().sorted(Comparator.comparing(e2 -> e2.getAge())).limit(1).collect(Collectors.toList()).get(0)
        ).collect(Collectors.toList());
        System.out.println(collect1);


        List<Person> collect2 = list.stream().
                collect(Collectors.groupingBy(e -> e.getPassword())).
                entrySet().stream().
                map(e -> e.getValue().stream().sorted(Comparator.comparing(e2 -> e2.getAge())).findFirst().orElse(null))
                .collect(Collectors.toList());
        System.out.println(collect2);

    }

    // 找出按照密码分组，年龄最小的那个人的信息
    @Test
    public void personDemo3() {
        Person p1 = new Person("zhang", "123", 12);
        Person p2 = new Person("zhang", "123", 24);
        Person p3 = new Person("zhang", "124", 25);
        Person p4 = new Person("zhang", "124", 26);
        List<Person> list = Arrays.asList(p1, p2, p3, p4);

        List<Person> collect2 = list.stream().
                collect(Collectors.groupingBy(e -> e.getPassword())).
                entrySet().stream().
                map(e -> e.getValue().
                        stream().
                        sorted(Comparator.comparing(e2 -> e2.getAge())).
                        findFirst().orElse(null))
                .collect(Collectors.toList());
        System.out.println(collect2);
    }
}
