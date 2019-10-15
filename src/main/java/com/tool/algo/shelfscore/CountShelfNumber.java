package com.tool.algo.shelfscore;

import com.tool.base.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description: 计算货架的数量
 * @author: zhangyu
 * @create: 2019-07-08 11:00
 */
public class CountShelfNumber {
    @Test
    public void fun3() {
        List<String> list = FileUtils.getFileToList("shelf_score.csv");
        System.out.println(list.size());
        Map<String, Long> result = list.stream().collect(Collectors.groupingBy(e -> e.split(",")[0], Collectors.counting()));
        for (String shelfCode : result.keySet()) {
            int sum = 0;
            for (String s : list) {
                // System.out.println(s);
                String s1 = s.split(",")[0];
                // System.out.println(s1);
                if (shelfCode.equals(s1)) {
                    Integer shelfScore = Integer.valueOf(s.split(",")[1]);
                    //System.out.println(shelfCode);
                    sum += shelfScore;
                }
            }
            long avg = sum / Long.valueOf(result.get(shelfCode));
            result.put(shelfCode, avg);
        }
        List<String> avgShelfScoreList = new ArrayList<>();
        for (String shelfCode : result.keySet()) {
            // System.out.println(shelfCode + ":" + result.get(shelfCode));
            avgShelfScoreList.add(shelfCode + "," + result.get(shelfCode));
        }
        FileUtils.listToFile("avg_shelf_score.csv", avgShelfScoreList);
    }
}
