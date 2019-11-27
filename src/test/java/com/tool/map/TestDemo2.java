package com.tool.map;

import org.junit.Test;

import java.util.*;

/**
 * demo
 *
 * @author: zhangyu
 */
public class TestDemo2 {
    @Test
    public void mapTestDemo() {
        Map<String, Integer> map = new HashMap<>();
        List<String> strList = new ArrayList<>(Arrays.asList("a", "b", "a", "c", "c"));
        for (String str : strList) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.println(map.toString());
    }
}
