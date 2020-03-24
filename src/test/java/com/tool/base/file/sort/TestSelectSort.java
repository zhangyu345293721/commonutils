package com.tool.base.file.sort;

import com.tool.base.sort.SelectSort;
import org.junit.Test;

/**
 * 测试选择排序
 *
 * @author: zhangyu
 */
public class TestSelectSort {

    @Test
    public void testSelectSort() {
        int[] arr = {2, 3, 1, 4, 6, 0, 9, 3, 5};
        int[] ints = SelectSort.selectSort(arr);
        for (int number : ints) {
            System.out.print(number + " ");
        }
    }
}
