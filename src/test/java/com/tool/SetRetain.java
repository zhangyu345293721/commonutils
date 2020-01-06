package com.tool;

import java.util.ArrayList;

/**
 * set求交集
 *
 * @author: zhangyu
 */
public class SetRetain {
    /**
     * 比较两个集合并留下相同部分
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 布尔值
     */
    public static boolean compare(int[] arr1, int[] arr2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int a : arr1) {
            list1.add(a);
        }
        for (int b : arr2) {
            list2.add(b);
        }
        list1.retainAll(list2); //list1中6，5不在list2中执行该方法时进行了移除操作返回true，如果将arr1改为{1,2,3,4}，执行该方法无需进行移除操作返回false；
        System.out.println(list1);
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6, 5};
        int[] arr2 = {1, 2, 3, 4, 53};
        boolean b = compare(arr1, arr2);
        System.out.println(".....:" + b);
    }
}
