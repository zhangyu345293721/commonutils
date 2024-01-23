package com.tool.base;

import java.util.*;

/**
 * map进行测试
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MapSortUtils {
    /**
     * 对map按照key进行排序
     *
     * @param map 输入map
     * @return 链表
     */
    public Map<String, Integer> getMapSortedByKey(Map<String, Integer> map) {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.putAll(map);
        return treeMap;
    }

    /**
     * 对map按照value进行排序
     *
     * @param map 输入map
     * @return 链表
     */
    public List<Map.Entry<String, Integer>> getEntrysSortedByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entrys = new ArrayList(map.entrySet());
        Collections.sort(entrys, new MyComparator());
        return entrys;
    }

    /**
     * 比较器
     */
    class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }
}
