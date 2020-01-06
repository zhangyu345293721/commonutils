package com.algo.shelfscore;

import com.tool.base.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: utilsdemo
 * @description: 获取货架的分数
 * @author: zhangyu
 * @create: 2019-07-08 10:05
 */
public class GetShelfScore {
    @Test
    public void fun() {
        long startTime = System.currentTimeMillis();
        List<String> shelfScoreList = getShelfScore();
        long endTime = System.currentTimeMillis();
        FileUtils.listToFile("shelf_score_8_7.csv", shelfScoreList);
        System.out.println((endTime - startTime) / 1000 + "秒");
    }

    /**
     * @Description: 获取货架的分数
     * @Author: zhangyu
     */
    public List<String> getShelfScore() {
        List<String> shelfSocres = new ArrayList<>();
        List<String> list = FileUtils.getFileToList("C:\\Users\\octopus\\Documents\\NetSarang Computer\\6\\Xshell\\Sessions\\athena-2019-08-07-22-1.log");
        String pattern = ".*\"shelfCode\":\"(\\S\\d+)\".*\"shelfScore\":(\\d+).*";
        Pattern r = Pattern.compile(pattern);
        // 创建 Pattern 对象
        for (String line : list) {
            // 现在创建 matcher 对象
            Matcher m = r.matcher(line);
            if (m.find()) {
                String shelfScore = m.group(1) + "," + m.group(2);
                shelfSocres.add(shelfScore);
            }
        }
        return shelfSocres;
    }
}
