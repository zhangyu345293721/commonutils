package com.algo.greedyalgorithm;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @program javacode
 * @description: 使用贪心算法遍历路径
 * @author: zhangyu
 * @create: 2019/09/27 23:03
 */
public class GreedyAlgo2 {
    @Test
    public void fun() {
        double[][] arr = {
                {0, 2, 3, 2, 5},
                {1, 0, 9, 2, 6},
                {1, 3, 0, 1, 4},
                {2, 1, 2, 0, 5},
                {2, 1, 4, 9, 0}
        };
        double[] row = {3, 5, 10, 3, 8};

        // 保存已经遍历过的行
        Set<Integer> set = new HashSet<>();
        double totalDistance = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            Pair<Double, Integer> nextPair = getNextPoint(set, row);
            // 获取已经遍历过的行
            index = nextPair.getValue();
            row = arr[index];
            set.add(index);
            totalDistance += nextPair.getKey();
        }
        System.out.println("最短路径为:" + totalDistance);
    }

    // 返回距离和已经遍历过的数的点
    private Pair<Double, Integer> getNextPoint(Set<Integer> set, double[] row) {
        int minIndex = -1;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0 && !set.contains(i) && min > row[i]) {
                // 后面要在该逻辑上加限制条件
                min = row[i];
                minIndex = i;
            }
        }
        // 输出按照行的顺序
        // System.out.println(minIndex);
        return new Pair<>(min, minIndex);
    }
}
