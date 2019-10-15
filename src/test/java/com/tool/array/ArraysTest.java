package com.tool.array;

/**
 * 随机打印出来所有的数组
 *
 * @author zhangyu
 */


import org.junit.jupiter.api.Test;

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

    @Test
    public void fun() {
        double[][] arr = {
                {1, 2.3, 4},
                {1, 0, 3, 4},
                {1, 2, 0, 4},
                {1, 2, 3, 0}
        };
        double[][] newArr = new double[arr.length - 1][arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                newArr[i - 1][j - 1] = arr[i][j];
            }
        }

        System.out.println(newArr.length + ":" + newArr[0].length);
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

