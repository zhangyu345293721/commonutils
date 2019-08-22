package com.zhang.shelfscore;

import com.zhang.read.GZFiletoList;
import com.zhang.read.ListToFile;
import com.zhang.read.ReadFileToLine;
import org.junit.jupiter.api.Test;

import java.util.*;
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
        for (int i = 0; i < 12; i++) {
            String s = "";
            if (i < 10) {
                s = "athena-2019-06-18-0" + i;
            } else {
                s = "athena-2019-06-18-" + i;
            }
            String strs[] = {s + "-1.log.gz", s + "-2.log.gz"};
            List<String> list = getAlllist(strs);
            List<String> shelfScoreList = getShelfScore(list);
            ListToFile.listToFile("shelf_score_6_18_" + i + ".csv", shelfScoreList);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000 + "秒");
    }

    /**
     * @Description: 获取货架的分数
     * @return: 货架和货架分数
     * @Author: zhangyu
     */
    public List<String> getShelfScore(List<String> list) {
        List<String> shelfScoreList = new ArrayList<>();
        // String[] s = {"athena-2019-06-18-23-1.log.gz", "athena-2019-06-18-23-2.log.gz"};
        String path = "D:\\software\\618\\athena-2019-06-18-00-1.log.gz";
        // String path="C:\\Users\\octopus\\Documents\\NetSarang Computer\\6\\Xshell\\Sessions\\athena-2019-08-07-22-1.log";
        String pattern = ".*\"shelfCode\":\"(\\S\\d+)\".*\"shelfScore\":(\\d+).*";
        Map<String, String> shelfScoreMap = new HashMap<>();
        Pattern r = Pattern.compile(pattern);
        for (String line : list) {
            Matcher m = r.matcher(line);
            if (m.find()) {
                shelfScoreMap.put(m.group(1), m.group(2));
                System.out.println(m.group(1) + "----" + m.group(2));
            }
        }
        // 将map的数据插入到链表当中
        for (String key : shelfScoreMap.keySet()) {
            String line = key + "," + shelfScoreMap.get(key);
            shelfScoreList.add(line);
        }
        return shelfScoreList;
    }

    public List<String> getAlllist(String[] strs) {
        List<String> newList = new ArrayList<>();
        String path = "D:\\software\\618\\";
        for (String fileName : strs) {
            List<String> list = GZFiletoList.getGzFileToList(path + fileName);
            newList.addAll(list);
        }
        return newList;
    }
}
