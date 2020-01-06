package com.algo.computetime;

import com.tool.base.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 计算方法调用的执行时间
 *
 * @author zhangyu
 */
public class ComputeTime {
    @Test
    public void fun() {
        String[] fileNames = {"beetle-2019-09-27-15-1.log.gz", "beetle-2019-09-27-15-2.log.gz", "beetle-2019-09-27-16-1.log.gz", "beetle-2019-09-27-16-2.log.gz"};
        String path = "C:\\Users\\octopus\\Desktop\\beetle929\\" + fileNames[0];
        List<String> list = FileUtils.getGzFileToList(path);

        // 生成时间的链表
        List<Integer> timeList = getTimeList(list);

        // 每个时间出现次数统计
        Map<Integer, Integer> map = getAppearTimes(timeList);

        //将map写入到文件中
        buildMapInFile(map, "map.csv");

        // 计算平均运行时间
        double averageTime = getAverageTime(timeList);
        System.out.println(averageTime);

    }


    /**
     * 把时间转成毫秒值    2019-09-27 15:18:48:310
     *
     * @param date 时间参数
     * @return 返回长整型13位毫秒数
     */
    public long getLongTime(String date) {
        long time = -1;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            time = simpleDateFormat.parse(date).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 将list转成map并统计出现次数
     *
     * @param list 传入李斯特
     * @return 返回map和出现次数
     */
    private Map<Integer, Integer> getAppearTimes(List<Integer> list) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer num : list) {
            if (map.keySet().contains(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;
    }

    /**
     * 从list中提取需要的数据存入到list当中
     *
     * @param list list需要清洗的list
     * @return 返回清洗过后的list
     */
    private List<Integer> getTimeList(List<String> list) {
        String startTime = "";
        String endTime = "";
        List<Integer> timeList = new ArrayList<>();
        int flag = 1;
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            if (line.contains("开始调用算法推荐包材") && line.contains("输入")) {
                int index1 = line.indexOf("INFO");
                startTime = line.substring(0, index1).trim();
                flag = 0;
            }
            if (line.contains("BinPacking Solution start")) {
                int index2 = line.indexOf("INFO");
                endTime = line.substring(0, index2).trim();
                long longTime1 = getLongTime(startTime);
                long longTime2 = getLongTime(endTime);
                Long gapTime = longTime2 - longTime1;
                if (flag == 0) {
                    if (gapTime > 0 && gapTime < 1000) {
                        //System.out.println("运行时间为：" + gapTime + "ms");\
                        timeList.add(gapTime.intValue());
                    }
                }
            }
        }
        return timeList;
    }


    /**
     * 统计平均时间
     *
     * @param timeList 方法调用的时间
     * @return 返回运行的平均时间
     */
    public double getAverageTime(List<Integer> timeList) {
        int sum = 0;
        for (int num : timeList) {
            sum += num;
        }
        // System.out.println(sum * 1.0 / timeList.size());
        return sum * 1.0 / timeList.size();
    }

    /**
     * 将map输入到文件当中
     *
     * @param map     map传入
     * @param mapName mapName
     * @return 将map刷入到文件当中
     */
    public void buildMapInFile(Map<Integer, Integer> map, String mapName) {
        List<String> line = new ArrayList<>();
        for (int key : map.keySet()) {
            line.add(key + "," + map.get(key));
        }
        FileUtils.listToFile(mapName, line);
    }
}