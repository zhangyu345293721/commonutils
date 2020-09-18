package com.tool.algo.topk;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * topK算法
 *
 * @@author zhangyu (zhangyuyu417@gmail.com)
 */
public class TopK {
    @Test
    public void testTopK() {
        int arr[] = {-3, 1, 2, 9, 7, 5, 6, 8};
        int num = findKthLargest(arr, 2);
        System.out.println(num);
    }

    /**
     * 找到第K个最大数
     *
     * @param arr 数组
     * @param k   最大k个
     * @return 返回数字
     */
    private int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}