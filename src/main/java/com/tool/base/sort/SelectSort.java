package com.tool.base.sort;

/**
 * 选择排序
 *
 * @author:zhangyu
 */
public class SelectSort {

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
                    temp(arr, i, j);
                }
            }
        }
        return arr;
    }

    /**
     * 交换两个元素的位置
     *
     * @param arr 数组
     * @param i   位置i
     * @param j   位置j
     */
    public static void temp(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}