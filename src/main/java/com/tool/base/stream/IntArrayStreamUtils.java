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
 * @author: zhangyu
 */
public class IntArrayStreamUtils {

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
        String collect = Arrays.stream(arrays).boxed().map(e -> String.valueOf(e)).collect(Collectors.joining(""));
        return collect;
    }

    /**
     * int数组变成字list
     *
     * @param arrays int数组
     * @return
     */
    public List<Integer> intArray2List(int[] arrays) {
        if (ArrayUtils.isEmpty(arrays)) {
            return new ArrayList<>();
        }
        List<Integer> list = Arrays.stream(arrays).boxed().collect(Collectors.toList());
        return list;
    }

    /**
     * List< Integer > 转 int[]
     *
     * @param list int类型链表
     * @return int数组
     */
    public int[] list2IntArray(List<Integer> list) {
        if (CollectionUtil.isEmpty(list)) {
            return new int[0];
        }
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }

}
