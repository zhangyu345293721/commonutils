package com.tool.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map
 *
 * @author: zhangyu
 */
public class MapTestDemo {
    @Test
    public void mapTesDemo1() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        for (Integer integer : map.keySet()) {
            System.out.println(integer + "::" + map.get(integer));
        }
    }

    @Test
    public void mapTesDemo2() {
        Map<Integer, Integer> map = new HashMap<>();
        addInfo(map);
        for (Integer integer : map.keySet()) {
            System.out.println(integer + "::" + map.get(integer));
        }
    }

    private void addInfo(Map<Integer, Integer> map) {
        map.put(1, 2);
        map.put(2, 2);
    }

    @Test
    public void subStringTestDemo() {
        String a = "abc";
        System.out.println(a.substring(1));
    }
}
