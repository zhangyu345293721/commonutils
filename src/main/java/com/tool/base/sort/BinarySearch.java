package com.tool.base.sort;

/**
 * 时间复杂度:Log(n) 空间复杂度:O(1)
 *
 * @author zhangyu
 **/


public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 5;
        int index = binarySearchTest(arr, key);
        System.out.println(index);
    }

    /**
     * 如果找到了直接进行返回，如果没有找到就继续去找
     *
     * @param arr 数组
     * @param key 关键字
     * @return 位置
     */
    private static int binarySearchTest(int[] arr, int key) {
        int i = 0;
        int j = arr.length - 1;
        int middle = i + (j - i) / 2;  //防止middle的和超过Integer.MAX_VALUE的值
        while (i <= j) {
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
}
