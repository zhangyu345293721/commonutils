package com.tool.base.sort;

import java.util.Arrays;

/**
 * 类描述:二分查找的精髓在于控制循环的次数，进行遍历
 *
 * @author: zhangyu
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arrs = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        quickSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
    }


    /**
     * 快速排序,递归算法
     *
     * @param arr  数组
     * @param low  低位
     * @param high 高位
     */
    private static void quickSort(int[] arr, int low, int high) {
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
}