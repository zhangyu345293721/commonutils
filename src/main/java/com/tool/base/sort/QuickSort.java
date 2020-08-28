package com.tool.base.sort;

import com.google.common.primitives.Ints;

import java.util.Arrays;

/**
 * 类描述:二分查找的精髓在于控制循环的次数，进行遍历
 *
 * @author: zhangyu
 */

public class QuickSort {

    /**
     * 快速排序,递归算法
     *
     * @param arr  数组
     * @param low  低位
     * @param high 高位
     */
    public static void quickSort(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        int key = arr[start];
        while (start < end) {
            // 要从尾到前面进行比较
            while (start < end && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 要从前到后进行比较
            while (start < end && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if (start > low) {
            quickSort(arr, low, start - 1);
        }
        if (end < high) {
            quickSort(arr, end + 1, high);
        }
    }

    /**
     * 快速排序,递归算法
     *
     * @param arr 输入数组
     * @return
     */
    public static int[] quickSort(int[] arr) {
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