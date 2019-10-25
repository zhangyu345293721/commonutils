package com.tool.function.generics;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 测试泛型方法
 *
 * @author: zhangyu
 */
public class GenericsFunction {
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

    // 测试泛型方法
    @Test
    public void personDemo() {
        Person p1 = new Person("zhang", "12", 12);
        Person p2 = new Person("zhang", "123", 24);
        List<Person> list = Arrays.asList(p1, p2);
        savePerson(list);
    }
}
