package com.algo.telphonedemo;

/**
 * @program: utilsdemo
 * @author: zhangyu
 * @create: 2019-08-20 19:14
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 合并每个算法的区间
 * @Author: zhangyu
 */
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            //return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
            if (a.start < b.start) {
                return -1;
            } else {
                if (a.start == b.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }

    // 合并区间
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
       /* for(Interval interval:intervals){
            System.out.println(interval.start+"--"+interval.end);
        }*/
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }
}