package com.zhang.arr;

/**
 * 随机打印出来所有的数组
 *
 * @author zhangyu
 */


import java.util.*;

public class ArraysTest {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }
        List<Integer> list = randomArr(data);
        System.out.println(list);
    }

    // 把一个数组打乱顺序
    private static List<Integer> randomArr(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }
}

