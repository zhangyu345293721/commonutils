package com.tool.base.file.sort;

import com.tool.base.sort.BubbleSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试快速排序
 *
 * @author: zhangyu
 */
public class TestBubbleSort {

    @Test
    public void testBubbleSort() {
        int[] arrs = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }
}
