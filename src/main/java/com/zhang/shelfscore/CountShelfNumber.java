package com.zhang.shelfscore;

import com.zhang.read.ListToFile;
import com.zhang.read.ReadFileToLine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
   /* @Test
    public void fun() {
        List<String> list = ReadFileToLine.getFileToList("shelf_score.csv");
        //list.stream().map(e->e.split(",")[0],);
        //  Map<String, Long> result = items.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            String[] strs = s.split(",");
            map.put(strs[0], Integer.valueOf(strs[1]));
        }
        System.out.println(map.size());
    }*/

  /*  @Test
    public void fun2() {
        //  Map<String, Long> result = items.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        List<String> list = ReadFileToLine.getFileToList("shelf_score.csv");
        Map<String, Long> result = list.stream().collect(Collectors.groupingBy(e -> e.split(",")[0], Collectors.counting()));
        for (String key : result.keySet()) {
            System.out.println(key + ":" + result.get(key));
        }
    }*/

    @Test
    public void fun3() {
        List<String> list = ReadFileToLine.getFileToList("shelf_score.csv");
        System.out.println(list.size());
        Map<String, Long> result = list.stream().collect(Collectors.groupingBy(e -> e.split(",")[0], Collectors.counting()));
        for (String shelfCode : result.keySet()) {
            int sum = 0;
            for (String s : list) {
                //System.out.println(s);
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
        ListToFile.listToFile("avg_shelf_score.csv", avgShelfScoreList);
    }
}
