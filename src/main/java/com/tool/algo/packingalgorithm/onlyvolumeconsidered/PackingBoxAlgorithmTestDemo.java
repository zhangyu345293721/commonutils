package com.tool.algo.packingalgorithm.onlyvolumeconsidered;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试装箱算法
 *
 * @author: zhangyu
 */
public class PackingBoxAlgorithmTestDemo {
    @Test
    public void goodsInBoxTestDemo() {

        Map<String, Integer> boxsType = new HashMap();

        boxsType.put("A", 10);
        boxsType.put("B", 35);
        boxsType.put("C", 25);
        boxsType.put("D", 30);
        boxsType.put("E", 40);
        boxsType.put("F", 5);


        // 订单
        Map<String, Integer> goodsType = new HashMap();
        goodsType.put("2", 20);
        goodsType.put("3", 17);
        goodsType.put("4", 16);
        goodsType.put("5", 15);
        goodsType.put("6", 9);
        goodsType.put("7", 8);
        goodsType.put("8", 5);
        goodsType.put("9", 4);
        goodsType.put("10", 3);
        goodsType.put("11", 2);
        goodsType.put("12", 1);

        long startTime = System.currentTimeMillis();
        PackingBoxAlgorithm algorithm = new PackingBoxAlgorithm(boxsType, goodsType);
        Map<String, Long> resultMap = algorithm.getResult();
        System.out.println(resultMap.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("程序的运行时间：" + (endTime - startTime) + "ms");

    }
}
