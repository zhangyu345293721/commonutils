package com.zhang.shelfscore;

import com.zhang.read.ListToFile;
import com.zhang.read.ReadFileToLine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: utilsdemo
 * @description: 获取货架的分数
 * @author: zhangyu
 * @create: 2019-07-08 10:05
 */
public class GetShelfScoreForMap {
    @Test
    public void fun() {
        long startTime = System.currentTimeMillis();
        List<String> shelfScoreList = getShelfScore();
        long endTime = System.currentTimeMillis();
        ListToFile.listToFile("shelf_score_8_7_2.csv", shelfScoreList);
        shelfScoreList.stream().forEach(e -> System.out.println(e));
        System.out.println((endTime - startTime) / 1000 + "秒");
    }

    /**
     * @Description: 获取货架的分数
     * @return: 货架和货架分数
     * @Author: zhangyu
     */
    public List<String> getShelfScore() {
        List<String> shelfScoreList = new ArrayList<>();
        List<String> list = ReadFileToLine.getFileToList("C:\\Users\\octopus\\Documents\\NetSarang Computer\\6\\Xshell\\Sessions\\athena-2019-08-07-22-1.log");
        String pattern = ".*\"shelfCode\":\"(\\S\\d+)\".*\"shelfScore\":(\\d+).*";
        Map<String, String> shelfScoreMap = new HashMap<>();
        Pattern r = Pattern.compile(pattern);
        // 创建 Pattern 对象
        for (String line : list) {
            // 现在创建 matcher 对象
            Matcher m = r.matcher(line);
            if (m.find()) {
                shelfScoreMap.put(m.group(1), m.group(2));
            }
        }
        // 将map的数据插入到链表当中
        for (String key : shelfScoreMap.keySet()) {
            String line = key + "," + shelfScoreMap.get(key);
            shelfScoreList.add(line);
        }
        return shelfScoreList;
    }
}
