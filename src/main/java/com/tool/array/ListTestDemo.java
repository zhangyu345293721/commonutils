package com.tool.array;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * List测试demo
 *
 * @author: zhangyu
 */
public class ListTestDemo {
    // 测试copyAndWriteList
    @Test
    public void TestCopyAndWriteListDemo() {
        List<Person> list = new CopyOnWriteArrayList();

        Person person1 = new Person("zhangyu", "123", 23);
        Person person2 = new Person("zhangsan", "yu", 23);
        Person person3 = new Person("tantuo", "tangtuo", 21);

        list.add(person1);
        list.add(person2);
        list.add(person3);

        for (Person p : list) {
            if (p.getUserName().equals("zhangyu")) {
                list.remove(p);
                list.add(p);
            }
        }

        System.out.println(list);
    }

    // 把一个对象移动到最后
    @Test
    public void TestListDemo2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(1));
        list.add(1);
        System.out.println(list);
    }
}
