package com.tool.algo.greedyalgorithm;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用贪心算法遍历路径
 *
 * @author: zhangyu
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


    /**
     * 返回距离和已经遍历过的数的点
     *
     * @param set set集合
     * @param row 数组
     * @return 键值对
     */
    private Pair<Double, Integer> getNextPoint(Set<Integer> set, double[] row) {
        int minIndex = -1;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0 && !set.contains(i) && min > row[i]) {
                min = row[i];
                minIndex = i;
            }
        }
        return new Pair<>(min, minIndex);
    }
}
