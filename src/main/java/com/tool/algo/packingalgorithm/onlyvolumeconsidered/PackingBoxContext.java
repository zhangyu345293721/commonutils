package com.tool.algo.packingalgorithm.onlyvolumeconsidered;

import lombok.Data;

import java.util.Map;

/**
 * 装箱算法的方法类
 *
 * @author: zhangyu
 */
@Data
public class PackingBoxContext {
    private Map<String, Integer> boxsMap;
    private Map<String, Integer> goodsMap;
}
