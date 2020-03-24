package com.tool.base.sort;

/**
 * 冒泡排序(时间复杂度：O(n^2) 空间复杂度:O(1))
 *
 * @author zhangyu
 **/

public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
    public  void bubbleSort(int[] arr) {
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
