package com.zhang.shelfscore;

import com.zhang.read.ListToFile;
import com.zhang.read.ReadFileToLine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description: 获取货架的数据
 * @author: zhangyu
 * @create: 2019-07-08 13:54
 */
public class GetLoadRobotEvent {
    @Test
    public void fun() {
        List<String> list = getShelfScore();
        ListToFile.listToFile("robot_event.txt", list);
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println("map的长度:" + map.size());
    }

    public List<String> getShelfScore() {
        List<String> shelfSocres = new ArrayList<>();
        List<String> list = ReadFileToLine.getFileToList("d:/software/athena-2019-07-08-09-1.log");
        String shelfLoadRegex = "^(.*)\\sINFO.*show shelf occupied cells.*robotId:(\\d*),\\staskId:(\\d*).*shelfCode:(.*),\\soccupiedCells.*loc=\\((.*),(.*)\\),.*$";
        Pattern r = Pattern.compile(shelfLoadRegex);
        // 创建 Pattern 对象
        for (String line : list) {
            // 现在创建 matcher 对象
            Matcher m = r.matcher(line);
            if (m.find()) {
                String shelfCode = m.group(4);
                System.out.println(shelfCode);
                shelfSocres.add(shelfCode);
            }
        }
        return shelfSocres;
    }
}
