package com.tool.algo.packingalgorithm.onlyvolumeconsidered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    // 计算结果    订单编号组成的List为key,箱子型号为value
    private Map<List<String>, String> resultMap = new HashMap();

    public Map<String, Long> calculate(PackingBoxContext context) {
        Map<String, Integer> boxsMap = context.getBoxsMap();
        Map<String, Integer> goodsMap = context.getGoodsMap();
        List<Map.Entry<String, Integer>> goodsList = goodsMap.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).collect(Collectors.toList());
        List<Map.Entry<String, Integer>> boxsList = boxsMap.entrySet().stream().sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).collect(Collectors.toList());

        //开始执行装箱操作
        executePackingBox(boxsList, goodsList);
        Map<String, Long> boxsTypeAndNumMap = resultMap.values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(boxsTypeAndNumMap.toString());
        return boxsTypeAndNumMap;
    }

    /**
     * 执行装箱操作
     *
     * @param boxsList  顺序排序的box
     * @param goodsList 倒序排序的goods
     */
    private void executePackingBox(List<Map.Entry<String, Integer>> boxsList, List<Map.Entry<String, Integer>> goodsList) {
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
     * @param remainVolume 箱子剩余容量
     * @param goodsList    商品链表
     * @param goodsId      该箱子能装物品id
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
}

