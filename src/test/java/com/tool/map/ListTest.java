package com.tool.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统计字符串出现次数
 * 利用jdk8测试defaut类型(添加利用stream流来操作map)
 *
 * @author zhangyu
 **/

public class ListTest {
    @Test
    public void HashMapTest() {
        int[] arr = {1, 2, 3, 1, 1, 2, 4, 6};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);

    }

    @Test
    public void HashMapTest2() {
        int[] arr = {1, 2, 3, 1, 1, 2, 4, 6};
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.toList()).stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map);
    }

    @Test
    public void HashMapTest3() {
        int[] arr = {1, 2, 3, 1, 1, 2, 4, 6};
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map);
    }
}
