package com.tool.array;

import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

/**
 * 测试把list中的一个对象移到最后面
 *
 * @author: zhangyu
 */
public class ListTestDemo {
    // 把一个对象从最中间移到最后
    @Test
    public void TestCopyAndWriteListDemo() {
        List<Person> list = new ArrayList<>();

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

    // 把一个数字移动到最后
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

    // 把一个数字移动到最后
    @Test
    public void JudgeEvenAndOdd() {
        int a = 4;
        if ((a & 1) == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd ");
        }
    }

    @Test
    public void treeMapGetFirst() {
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "zhangyu");
        map.put(2, "zhangsan");
        map.put(3, "wangwu");

        System.out.println(getMinKeysValue(map));
    }

    /**
     * 获取map的最小key的value
     *
     * @param map 传入map的值
     * @return String
     */
    public static String getMinKeysValue(Map<Integer, String> map) {
        int key = map.keySet().stream().min(Comparator.comparing(Function.identity())).get();
        return map.get(key);
    }

    @Test
    public void listPrintTestDemo() {

        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 3, 4));
        System.out.println(list);
    }
}
