package com.tool.array;

/**
 * 随机打印出来所有的数组
 *
 * @author zhangyu
 */


import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Permutation;

import java.util.*;

public class ArraysTest {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }
        List<Integer> list = randomArr(data);
        System.out.println(list);
    }

    // 把一个数组打乱顺序
    private static List<Integer> randomArr(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    @Test
    public void fun() {
        double[][] arr = {
                {1, 2.3, 4},
                {1, 0, 3, 4},
                {1, 2, 0, 4},
                {1, 2, 3, 0}
        };
        double[][] newArr = new double[arr.length - 1][arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                newArr[i - 1][j - 1] = arr[i][j];
            }
        }
        System.out.println(newArr.length + ":" + newArr[0].length);
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void fun11() {
        Permutation.of(Arrays.asList("a", "b", "c"));
    }

    @Test
    public void arrayTestDemo() {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] num2 = new int[n];
        num2[0] = 1;
        num2[2] = 4;
        arr = num2;
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 按照要求合并两个数组
     *
     * @param nums1 数组1
     * @param m     开始位置
     * @param nums2 数组2
     * @param n     开始位置
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < 1 || nums1 == null) {
            return null;
        }
        if (nums2.length < 1 || nums2 == null) {
            return null;
        }
        int[] arr = new int[nums1.length];
        int index = 0;
        int i = 0;
        int j = 0;
        // 按照顺序插入到另外一个链表中
        while ((i < m) && (j < n)) {
            if (nums1[i] <= nums2[j]) {
                arr[index] = nums1[i];
                i++;
                index++;
            } else {
                arr[index] = nums2[j];
                j++;
                index++;
            }
        }
        // 如果没插入完整继续
        while (i < m) {
            arr[index] = nums1[i];
            i++;
            index++;
        }
        // 如果没插入完整继续
        while (j < n) {
            arr[index] = nums2[j];
            j++;
            index++;
        }
        return arr;
    }

    @Test
    public void merageArrayTestDemo() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    @Test
    public void splitListTestDemo() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(5);

        Map<Integer, List<Integer>> map = get(integers, 2);
        System.out.println(map.toString());

    }

    /**
     * 切割list
     *
     * @param source
     */
    public static <T> Map<Integer, List<T>> get(List<T> source, int n) {
        Map<Integer, List<T>> result = new LinkedHashMap<>();
        int remaider = source.size() % n;
        int number = source.size() / n;
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remaider > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.put(i, value);
        }
        return result;
    }

    @Test
    public void listTestDemo() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int num = list.stream().findFirst().get().intValue();
        System.out.println(num);
    }
}


