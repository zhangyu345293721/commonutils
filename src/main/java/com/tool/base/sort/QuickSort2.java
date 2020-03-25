package com.tool.base.sort;

import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 类描述:二分查找的精髓在于控制循环的次数，进行遍历
 *
 * @author: zhangyu
 */

public class QuickSort2 {

    @Test
    public void testQuickSort() {
        int[] arr = {4, 1, 3, 4, 6, 1, 9, 5};
        int[] ints = quickSort(arr);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * 快速排序,递归算法
     *
     * @param arr 数组
     */
    public int[] quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int pivot = arr[arr.length / 2];
        int[] left = Arrays.stream(arr).boxed().filter(e -> e < pivot).mapToInt(e -> e).toArray();
        int[] middle = Arrays.stream(arr).boxed().filter(e -> e == pivot).mapToInt(e -> e).toArray();
        int[] right = Arrays.stream(arr).boxed().filter(e -> e > pivot).mapToInt(e -> e).toArray();
        return Ints.concat(quickSort(left), middle, quickSort(right));
    }
}