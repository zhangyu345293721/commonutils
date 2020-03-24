package com.tool.base.file.sort;

import com.tool.base.sort.BinarySearch;
import org.junit.Test;

/**
 * 测试二分查找
 *
 * @author: zhangyu
 */
public class TestBinarySearch {

    @Test
    public void testBinarySearch() {
        int[] arrs = {1, 2, 4, 12, 15};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearch(arrs, 12);
        System.out.println(index);
    }
}
