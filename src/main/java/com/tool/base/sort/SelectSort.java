package com.tool.base.sort;

/**
 * 选择排序
 * author:zhangyu
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 6, 0, 9, 3, 5};
        selectSort(arr);
        for (int number : arr) {
            System.out.print(number + " ");
        }
    }

    /**
     * 选择排序
     *
     * @param arr 数组
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp(arr, i, j);
                }
            }
        }
    }

    /**
     * 交换两个元素的位置
     *
     * @param arr 数组
     * @param i   位置i
     * @param j   位置j
     */
    private static void temp(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}