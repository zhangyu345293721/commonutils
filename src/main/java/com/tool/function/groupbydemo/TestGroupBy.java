package com.tool.function.groupbydemo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 测试groupby
 *
 * @author: zhangyu
 */
public class TestGroupBy {
    // 对统计此时进行分组
    @Test
    public void fun() {
        User u1 = new User(1, "aa", "aap", 23);
        User u2 = new User(2, "aa", "aap", 23);
        User u3 = new User(3, "bb", "aap", 23);
        User u4 = new User(4, "cc", "aap", 23);
        User u5 = new User(5, "cc", "aap", 23);
        User u6 = new User(6, "cc", "aap", 23);
        User u7 = new User(7, "aa", "aap", 24);
        List<User> list = new ArrayList();
        list.add(u1);
        list.add(u2);
        list.add(u7);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);

        // 统计出现个数,双重统计
        Map<String, Map<Integer, Long>> map = list.stream().collect(Collectors.groupingBy(User::getUserName, Collectors.groupingBy(User::getAge, Collectors.counting())));

        for (String name : map.keySet()) {
            System.out.println(name + ";" + map.get(name));
        }
    }

    // 对重复次数进行统计
    @Test
    public void fun2() {
        List<String> parameterList = Arrays.asList("1", "2", "2", "3", "3", "4", "4", "5", "6", "7", "8");
        Map<String, Long> map = parameterList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String name : map.keySet()) {
            System.out.println(name + ":" + map.get(name));
        }
    }

    // 找出重复的字符,对它进行过滤
    @Test
    public void fun3() {
        List<String> parameterList = Arrays.asList("1", "2", "2", "3", "3", "4", "4", "5", "6", "7", "8");

        List<String> resultList = parameterList.stream().collect(Collectors.collectingAndThen(Collectors
                .groupingBy(Function.identity(), Collectors.counting()), map -> {
            map.values().removeIf(size -> size == 1);
            List<String> tempList = new ArrayList<>(map.keySet());
            return tempList;
        }));
        System.out.println(resultList);
    }
}
