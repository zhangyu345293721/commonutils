package com.tool.algo.computetime;

import com.tool.bean.Use;
import com.tool.readfile.files.ListToFile;
import com.tool.readfile.files.ReadFileToLine;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 计算方法调用的执行时间
 *
 * @author zhangyu
 */
public class ComputeTime2 {
    @Test
    public void fun() {
        // 0:代表开始，1代表结束
        List<String> list = ReadFileToLine.getFileToList("newList.csv");
        List<Use> newList = convertStrToUse(list);

       /* for (Use use : newList) {
            System.out.println(use);
        }*/

        Map<String, List<Use>> map = newList.stream().collect(Collectors.groupingBy(Use::getThread));


        Map<String, List<Use>> valueSortedMap = convertValueSortedMap(map);

       /* for (String s : valueSortedMap.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }*/
        int count = 0;
        int sum = 0;
        // 计算时间
        for (String thread : valueSortedMap.keySet()) {
            List<Use> useList = valueSortedMap.get(thread);
            for (int i = 0; i < useList.size() - 1; i++) {
                Use use1 = useList.get(i);
                Use use2 = useList.get(i + 1);
                if (use1.getFlag() == 0 && use2.getFlag() == 1) {
                    long time1 = use1.getTime();
                    long time2 = use2.getTime();
                    if (time2 - time1 > 1000) {
                        System.out.println(getDateTime(use1.getTime()) + "," + use1.getThread() + "===" + getDateTime(use2.getTime()) + "," + use2.getThread());
                        System.out.println(time2 - time1);
                    }
                    if (time2 - time1 <= 1000) {
                        sum += (time2 - time1);
                        count++;
                    }
                }
            }
        }
        System.out.println(sum * 1.0 / count);
    }

    private Map<String, List<Use>> convertValueSortedMap(Map<String, List<Use>> map) {
        Map<String, List<Use>> valueSortedMap = new HashMap<>();
        for (String s : map.keySet()) {
            List<Use> sortedList = map.get(s).stream().sorted(Comparator.comparing(Use::getTime)).collect(Collectors.toList());
            valueSortedMap.put(s, sortedList);
        }
        return valueSortedMap;
    }

    private List<Use> convertStrToUse(List<String> list) {
        List<Use> newList = new ArrayList<>();
        for (String line : list) {
            String[] strs = line.split(",");
            Long time = Long.valueOf(strs[0]);
            String thread = strs[1];
            int flag = Integer.valueOf(strs[2]);

            Use use = new Use();
            use.setFlag(flag);
            use.setThread(thread);
            use.setTime(time);

            newList.add(use);
        }
        return newList;
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
     * 将毫秒值转成日期时间    2019-09-27 15:18:48:310
     *
     * @param date 时间参数
     * @return 返回长整型13位毫秒数
     */
    public String getDateTime(long time) {
        Date d = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        return String.valueOf(sdf.format(d));
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
        ListToFile.listToFile(mapName, line);
    }
}