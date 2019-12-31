package com.tool.algo.greedyalgorithm;

import com.tool.base.ArrayUtils;
import com.tool.base.CollectionUtil;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用贪心算法遍历路径
 *
 * @author: zhangyu
 */
public class GreedyAlgo {
    @Test
    public void fun() {
        double[][] arr = {
                {0, 2, 3, 2, 5},
                {1, 0, 9, 2, 6},
                {1, 3, 0, 1, 4},
                {2, 1, 2, 0, 5},
                {2, 1, 4, 9, 0}
        };
        Set<Integer> set = new HashSet<>();
        double totalDistance = 0;
        double[] pointStart = {3, 5, 10, 3, 8};
        double[] firstdtDistanceAndIndexArr = getDistanceAndIndex(pointStart);
        double distance = firstdtDistanceAndIndexArr[0];
        totalDistance += distance;
        int index = (int) firstdtDistanceAndIndexArr[1];
        set.add(index);

        for (int i = 0; i < 4; i++) {
            double[] row = arr[index];
            double[] nextArr = getNextPoint(set, row);
            index = (int) nextArr[1];
            set.add(index);
            totalDistance += nextArr[0];
        }

        System.out.println(totalDistance);
    }

    /**
     * 获取下一个节点
     *
     * @param set 集合
     * @param row 行
     * @return 下一行
     */
    private double[] getNextPoint(Set<Integer> set, double[] row) {
        if (CollectionUtil.isEmpty(set) || ArrayUtils.isEmpty(row)) {
            return new double[0];
        }
        double[] nextArr = new double[2];
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0 && !set.contains(i) && min > row[i]) {
                min = row[i];
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0 && !set.contains(i) && min == row[i]) {
                nextArr[0] = min;
                nextArr[1] = i;
                return nextArr;
            }
        }
        return new double[0];
    }


    /**
     * 获取最小值，已经下标
     *
     * @param pointStart 起始点
     * @return 数组
     */
    private double[] getDistanceAndIndex(double[] pointStart) {
        if (ArrayUtils.isEmpty(pointStart)) {
            return new double[0];
        }
        double[] firstDistanceAndIndexArr = new double[2];
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < pointStart.length; i++) {
            if (min > pointStart[i]) {
                min = pointStart[i];
            }
        }
        for (int i = 0; i < pointStart.length; i++) {
            if (min == pointStart[i]) {
                firstDistanceAndIndexArr[0] = min;
                firstDistanceAndIndexArr[1] = i;
                return firstDistanceAndIndexArr;
            }
        }
        return new double[0];
    }
}
