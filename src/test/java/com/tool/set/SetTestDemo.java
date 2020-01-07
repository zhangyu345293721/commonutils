package com.tool.set;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试两个集合取交集
 *
 * @author: zhangyu
 */
public class  SetTestDemo {
    @Test
    public void setTestDemo1() {
        Set<Integer> set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        Set<Integer> set2 = new HashSet();
        set2.add(4);
        set2.add(6);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        Set<Integer> joinSet = new HashSet<>();
        joinSet.addAll(set1);
        joinSet.retainAll(set2);
        System.out.println(joinSet);
    }

    @Test
    public void testVar() {
        Person person = new Person();
        addNumber(person);
        System.out.println(person.getUserName());
    }

    private void addNumber(Person person) {
        person.setUserName("zhangyu");
    }
}

