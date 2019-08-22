package com.zhang.mergearray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: zhangyu
 */
public class MergeArrayDemo {
    @Test
    public void fun() {
        int[] arr1 = {1, 4, 7, 9};
        int[] arr2 = {2, 3, 5, 6, 7, 11, 14};

        int[] newArr = mergeTwoArr(arr1, arr2);
        System.out.println(Arrays.toString(newArr));
    }

    private int[] mergeTwoArr(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr1 == null) {
            return arr2;
        }
        if (arr2.length == 0 || arr2 == null) {
            return arr1;
        }

        int[] newArr = new int[arr1.length + arr2.length];
        // 定义i,j分别记录两个数组的下标
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < arr1.length && j < arr2.length) {
            // 当arr1中的元素小于或者等于arr2就放到新的元素中
            if (arr1[i] <= arr2[j]) {
                newArr[index] = arr1[i];
                index++;
                i++;
            } else {
                // 如果arr2中元素大
                newArr[index] = arr2[j];
                index++;
                j++;
            }
        }

        while (j < arr2.length) {
            newArr[index] = arr2[j];
            index++;
            j++;
        }
        while (i < arr1.length) {
            newArr[index] = arr1[i];
            index++;
            i++;
        }
        return newArr;
    }
}
