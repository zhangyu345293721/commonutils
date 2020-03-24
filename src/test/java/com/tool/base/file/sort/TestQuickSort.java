package com.tool.base.file.sort;

import com.tool.base.sort.QuickSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试快速排序
 *
 * @author: zhangyu
 */
public class TestQuickSort {

    @Test
    public void testQuickSort() {
        int[] arrs = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(arrs, 0, arrs.length - 1);
        System.out.println(Arrays.toString(arrs));
    }
}
