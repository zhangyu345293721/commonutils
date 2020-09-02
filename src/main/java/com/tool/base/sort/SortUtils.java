package com.tool.base.sort;

import com.google.common.primitives.Ints;

import java.util.Arrays;

/**
 * 二分查找，选择排序，快速排序，冒泡排序
 *
 * @author zhangyu
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
