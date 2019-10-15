package com.tool.function.collector.testsort.collector.testsort;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 测试排序
 * @author: zhangyu
 */
public class SortDemo {
    @Test
    public void fun() {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person();
        p1.setUserName("zhangyu");
        p1.setAge(21);
        p1.setPassword("12345");

        Person p2 = new Person();
        p1.setUserName("zhangyu");
        p1.setAge(21);
        p1.setPassword("12345");

        Person p3 = setPerson(new Person());

        list.add(p1);
        list.add(p2);
        list.add(p3);

        boolean flag = true;
        if (flag) {
            System.out.println("hhhhh是true");
        }
        // 按照age从小到大排序
        list.sort(Comparator.comparing(Person::getAge).reversed());
        System.out.println(list);
    }

    private Person setPerson(Person p3) {
        // Person p3 = new Person();
        p3.setUserName("lisi");
        p3.setAge(25);
        p3.setPassword("1234567");
        return p3;
    }
}
