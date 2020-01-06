package com.algo.packingalgorithm.onlyvolumeconsidered;

import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 装箱算法只考虑体积问题（一维问题）
 * <p>
 * 考虑的前提是一定能找到一种型号的箱子能装下商品
 *
 * @author: zhangyu
 */
public class PackingBoxAlgorithm {
    List<Map.Entry<String, Integer>> boxsList;
    List<Map.Entry<String, Integer>> goodsList;
    // 计算结果    订单编号组成的List为key,箱子型号为value
    private Map<List<String>, String> resultMap = new HashMap();

    /**
     * 根据箱型以及订单中的商品，返回每个箱型和需要箱子多少只。
     *
     * @param boxsMap  箱子型号和体积的map
     * @param goodsMap 物品型号和体积的map
     * @return 无返回值
     */
    public PackingBoxAlgorithm(Map<String, Integer> boxsMap, Map<String, Integer> goodsMap) {
        List<Map.Entry<String, Integer>> goodsList = goodsMap.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).collect(Collectors.toList());
        List<Map.Entry<String, Integer>> boxsList = boxsMap.entrySet().stream().sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).collect(Collectors.toList());
        this.boxsList = boxsList;
        this.goodsList = goodsList;
        //开始执行装箱操作
        executePackingBox();
    }

    /**
     * 执行装箱操作
     */
    private void executePackingBox() {
        // 终止条件为商品数量为空
        while (goodsList.size() > 0) {
            // 每次都取最前面商品
            Map.Entry<String, Integer> goodsEntry = goodsList.get(0);
            for (Map.Entry<String, Integer> boxEntry : boxsList) {
                // 每个箱子能装商品的编码
                List<String> goodsId = new ArrayList<>();
                if (boxEntry.getValue() >= goodsEntry.getValue()) {
                    // 箱子剩余大小
                    int remainVolume = boxEntry.getValue() - goodsEntry.getValue();
                    goodsId.add(goodsEntry.getKey());
                    goodsList.remove(goodsEntry);
                    if (remainVolume > 0) {
                        remainBoxVolumeUse(remainVolume, goodsList, goodsId);
                    }
                    resultMap.put(goodsId, boxEntry.getKey());
                    // 这个箱子用完之后就退出本层循环，继续找第二个箱子能装物品
                    break;
                }
            }
        }
    }

    /**
     * 箱子中剩下的体积能装的商品
     *
     * @param remainVolume 箱子的剩余容量
     * @param goodsList    商品的链表
     * @param goodsId      该箱子能装物品的id
     */
    private void remainBoxVolumeUse(int remainVolume, List<Map.Entry<String, Integer>> goodsList, List<String> goodsId) {
        for (int i = 0; i < goodsList.size(); i++) {
            Map.Entry<String, Integer> goodsEntry = goodsList.get(i);
            if (remainVolume > goodsEntry.getValue()) {
                goodsId.add(goodsEntry.getKey());
                goodsList.remove(goodsEntry);
                remainVolume -= goodsEntry.getValue();
            }
        }
    }

    /**
     * 统计箱子型号和数量
     *
     * @return 箱子的型号, 箱子数量map
     */
    public Map<String, Long> getResult() {
        System.out.println(resultMap.toString());
        Map<String, Long> boxsTypeAndNumMap = resultMap.values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return boxsTypeAndNumMap;
    }
}

