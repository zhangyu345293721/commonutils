package com.tool.base.sort;

/**
 * 时间复杂度:Log(n) 空间复杂度:O(1)
 *
 * @author zhangyu
 **/

public class BinarySearch {
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
}
