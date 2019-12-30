package com.tool.algo.shelfscore;

import com.tool.base.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 计算货架的数量
 *
 * @author: zhangyu
 */
public class CountShelfNumber {
    @Test
    public void fun3() {
        List<String> list = FileUtils.getFileToList("shelf_score.csv");
        System.out.println(list.size());
        Map<String, Long> result = list.stream().collect(Collectors.groupingBy(e -> e.split(",")[0], Collectors.counting()));
        for (Map.Entry<String, Long> entry : result.entrySet()) {
            String shelfCode = entry.getKey();
            int sum = 0;
            for (String s : list) {
                String s1 = s.split(",")[0];
                if (shelfCode.equals(s1)) {
                    Integer shelfScore = Integer.valueOf(s.split(",")[1]);
                    sum += shelfScore;
                }
            }
            long avg = sum / Long.valueOf(result.get(shelfCode));
            result.put(shelfCode, avg);
        }
        List<String> avgShelfScoreList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : result.entrySet()) {
            String shelfCode = entry.getKey();
            avgShelfScoreList.add(shelfCode + "," + result.get(shelfCode));
        }
        FileUtils.listToFile("avg_shelf_score.csv", avgShelfScoreList);
    }
}
