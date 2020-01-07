package com.tool.algo.topk;


import org.junit.jupiter.api.Test;

import java.util.*;


/**
 * 统计一串字符中，出现次数最多的k个数
 *
 * @author: zhangyu
 **/


public class TopKinChar {
    @Test
    public void fun() {
        char[] chs = {'a', 'a', 'a', 'c', 'b', 'c', 'd'};
        int k = 1;
        List<Character> list = getTopK(chs, k);
        System.out.println(list);
    }

    /**
     * 定义一个比较器的内部类
     */
    private class ValueComparator implements Comparator<Map.Entry<Character, Integer>> {
        public int compare(Map.Entry<Character, Integer> m, Map.Entry<Character, Integer> n) {
            return n.getValue() - m.getValue();
        }
    }

    /**
     * 找出topK 元素
     *
     * @param chs char数组
     * @param k   第k个最大值
     * @return 最大的链表
     */
    private List<Character> getTopK(char[] chs, int k) {
        Map<Character, Integer> map = new TreeMap<>();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        List<Character> newList = new ArrayList<>();
        for (Character ch : chs) {
            if (!map.keySet().contains(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        list.addAll(map.entrySet());
        if (k > map.keySet().size()) {
            newList.addAll(map.keySet());
            return newList;
        }
        ValueComparator vc = new ValueComparator();
        Collections.sort(list, vc);
        for (int i = 0; i < k; i++) {
            newList.add(list.get(i).getKey());
        }
        return newList;
    }
}
