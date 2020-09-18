package com.tool.base.stream;

import com.tool.base.ArrayUtils;
import com.tool.base.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jdk8流的工具类
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class IntArrayStreamUtils {

    private IntArrayStreamUtils() {
    }

    /**
     * 将int数组连接成字符串
     *
     * @param arrays 输入数组
     * @return 字符串
     */
    public String intArray2String(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return "";
        }
        return Arrays.stream(arrays).boxed().map(e -> String.valueOf(e)).collect(Collectors.joining(""));
    }

    /**
     * int数组变成字list
     *
     * @param arrays int数组
     * @return
     */
    public List<Integer> intArray2IntList(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return new ArrayList<>();
        }
        return Arrays.stream(arrays).boxed().collect(Collectors.toList());
    }

    /**
     * List< Integer > 转 int[]
     *
     * @param intList int类型链表
     * @return int数组
     */
    public int[] intList2IntArray(List<Integer> intList) {
        if (CollectionUtil.isEmpty(intList)) {
            return new int[0];
        }
        return intList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
