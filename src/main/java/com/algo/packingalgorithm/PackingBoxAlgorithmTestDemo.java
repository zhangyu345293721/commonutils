package com.algo.packingalgorithm;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 测试装箱算法
 *
 * @author: zhangyu
 */
public class PackingBoxAlgorithmTestDemo {
    @Test
    public void goodsInBoxTestDemo() {

        Map<Integer, Map<String, Object>> boxsType = new LinkedHashMap<Integer, Map<String, Object>>() {
            {
                // 假设有大中小三种型号的箱子,如下描述：
                /*
                 *  要求数据从数据库中取出来的时候是按照 箱子型号大小系数 (l长+w款+h高) 从小到大的顺序排好序的。這樣裝箱后可以得到近似合理的解
                 */
                // 1,小箱
                this.put(1, new LinkedHashMap<String, Object>() {
                    {
                        // 小箱 长 100厘米，宽100厘米，高120厘米
                        this.put("boxcode", 1);
                        this.put("l", 10);
                        this.put("w", 10);
                        this.put("h", 12);
                    }
                });
                // 2,中箱
                this.put(2, new LinkedHashMap<String, Object>() {
                    {
                        // 中箱 长200厘米，宽150厘米，高180厘米
                        this.put("boxcode", 2);
                        this.put("l", 10);
                        this.put("w", 80);
                        this.put("h", 90);
                    }
                });
                // 3,大箱
                this.put(3, new LinkedHashMap<String, Object>() {
                    {
                        // 大箱长50厘米,宽60厘米,高70厘米
                        this.put("boxcode", 3);
                        this.put("l", 50);
                        this.put("w", 60);
                        this.put("h", 70);
                    }
                });
            }
        };

        // 订单
        Map<Integer, Map<String, Integer>> goodsType = new LinkedHashMap<Integer, Map<String, Integer>>() {
            {
                /*
                 *  要求数据从数据库中取出来的时候是按照 商品大小系数 (l长+w款+h高) 从大到小的顺序排好序的。這樣裝箱后可以得到近似合理的解
                 */
                // 1,用的小冰箱10个
                this.put(1, new LinkedHashMap<String, Integer>() {
                    {
                        // 长 400厘米，宽500厘米，高600厘米；
                        this.put("l", 400);
                        this.put("w", 500);
                        this.put("h", 600);
                        this.put("n", 10);
                        this.put("t", 0);
                        // 是否可以躺着放，0，否；1，是，这个不能躺着放，而且所有商品均不能倒置，而且倒置和正着放置所占用空间一样。
                    }
                });
                // 2,电脑主机箱5台
                this.put(2, new LinkedHashMap<String, Integer>() {
                    {
                        // 长 57厘米，宽21厘米，高52厘米
                        this.put("l", 57);
                        this.put("w", 21);
                        this.put("h", 52);
                        this.put("n", 5);
                        this.put("t", 1);// 是否可以躺着放，0，否；1，是
                    }
                });
                // 3,笔记本电脑5台
                this.put(3, new LinkedHashMap<String, Integer>() {
                    {
                        // 长 33厘米，宽24厘米，高6厘米
                        this.put("l", 33);
                        this.put("w", 24);
                        this.put("h", 6);
                        this.put("n", 100);
                        this.put("t", 1);
                        // 是否可以躺着放，0，否；1，是
                    }
                });
            }
        };
        long startTime = System.currentTimeMillis();
        // 箱子的规格
        PackingBoxAlgorithm algorithm = new PackingBoxAlgorithm(boxsType, goodsType);
        Map<String, Integer> resultMap = algorithm.getResult();
        System.out.println(resultMap.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("程序的运行时间：" + (endTime - startTime) + "ms");
    }
}
