package com.tool.base.sort;

import com.google.common.primitives.Ints;

import java.util.Arrays;

/**
 * 二分查找，选择排序，快速排序，冒泡排序
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 **/

public class SortUtils {

    private SortUtils() {
    }

    /**
     * 如果找到了直接进行返回，如果没有找到就继续去找
     *
     * @param arr 数组
     * @param key 关键字
     * @return 位置
     */
    public int binarySearch(int[] arr, int key) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int middle = i + (j - i) / 2;  //防止middle的和超过Integer.MAX_VALUE的值
            if (key > arr[middle]) {
                i = middle + 1;
            } else if (key < arr[middle]) {
                j = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     * @return int[] 数组
     */
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     *
     * @param arr 数组
     */
    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSortHelper(arr, low, high);
    }

    /**
     * 快速排序,递归算法
     *
     * @param arr  数组
     * @param low  低位
     * @param high 高位
     */
    public static void quickSortHelper(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        int key = arr[start];
        while (start < end) {
            // 要从尾到前面进行比较
            while (start < end && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                swap(arr, start, end);
            }
            // 要从前到后进行比较
            while (start < end && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                swap(arr, start, end);
            }
        }
        if (start > low) {
            quickSortHelper(arr, low, start - 1);
        }
        if (end < high) {
            quickSortHelper(arr, end + 1, high);
        }
    }


    /**
     * 快速排序,递归算法
     *
     * @param arr 输入数组
     * @return 新数组
     */
    public static int[] quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int pivot = arr[arr.length / 2];
        int[] left = Arrays.stream(arr).boxed().filter(e -> e < pivot).mapToInt(e -> e).toArray();
        int[] middle = Arrays.stream(arr).boxed().filter(e -> e == pivot).mapToInt(e -> e).toArray();
        int[] right = Arrays.stream(arr).boxed().filter(e -> e > pivot).mapToInt(e -> e).toArray();
        return Ints.concat(quickSort2(left), middle, quickSort2(right));
    }

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换他们数字的值
     *
     * @param arr 数组
     * @param i   位置i
     * @param j   位置j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
