package com.tool.function;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 测试切割List
 *
 * @author: zhangyu
 */
public class SplitList {
    @Test
    public void splitListTestDemo() {
        List<Double> list = new ArrayList(Arrays.asList(0.1, 0.2, 0.3, 0.4));
        List<String> splitList = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"));
        Map<Integer, List<String>> map = getSplitMap(splitList, list);

        System.out.println(map);

    }

    /**
     * 将list按照规则进行分区间
     *
     * @param splitList 要划分的链表
     * @param list      输入要划分的规则
     * @return 返回map
     */
    private <T> Map<Integer, List<T>> getSplitMap(List<T> splitList, List<Double> list) {
        int startIndex = 0;
        int endIndex = 0;
        Map<Integer, List<T>> map = new HashMap<>();
        int size = splitList.size();
        int i = 0;
        for (; i < list.size() - 1; i++) {
            endIndex += list.get(i) * splitList.size();
            if (endIndex < size) {
                List<T> sub = splitList.subList(startIndex, endIndex);
                startIndex = endIndex;
                map.put(i, sub);
            } else {
                List<T> sub = splitList.subList(startIndex, size);
                map.put(i, sub);
                return map;
            }
        }
        if (startIndex < size) {
            List<T> lastSubList = splitList.subList(startIndex, size);
            map.put(i, lastSubList);
        }
        return map;
    }
}
