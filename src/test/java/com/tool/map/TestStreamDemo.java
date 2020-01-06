package com.tool.map;

import org.junit.Test;

import java.util.*;

/**
 * 测试流操作
 *
 * @author: zhangyu
 */
public class TestStreamDemo {
    @Test
    public void mapTestDemo() {
        Map<String, Integer> map = new HashMap<>();
        List<String> strList = new ArrayList<>(Arrays.asList("a", "b", "a", "c", "c"));
        for (String str : strList) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.println(map.toString());
    }

    @Test
    public void streamTestDemo2() {
        List<Integer> strList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer integer = strList.stream().reduce(Integer::sum).orElse(0);
        System.out.println(integer);
    }

    @Test
    public void streamTestDemo3() {
        List<Integer> strList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int sum = strList.stream().mapToInt(e -> Integer.valueOf(e)).sum();
        System.out.println(sum);
    }
}
