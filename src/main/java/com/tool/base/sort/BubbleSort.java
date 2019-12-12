package com.tool.base.sort;

import java.util.Arrays;

/**
 *
 * 冒泡排序(时间复杂度：O(n^2) 空间复杂度:O(1))
 * @author zhangyu
 *
 **/

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 24, 2, 1, 4, 5, 2, 9, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换两个数字的值
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    // 交换他们数字的值
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
