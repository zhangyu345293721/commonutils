package com.tool.base.file;

import com.tool.base.RandomUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 测试文件夹是不是存在, 不存在就新建一个
 *
 * @author: zhangyu
 */
public class FileDemo {
    @Test
    public void fun() {
        String path = "D:/333";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    @Test
    public void getFileListTestDemo() {
        String path = "D:\\var\\geekplus\\playback\\logTempDir";
        List<String> paths = FileUtils.getFilesPath(path);
        System.out.println(paths);
    }

    // 获取一个文件夹下的所有文件
    @Test
    public void fileTestDemo() {
        File[] files = new File("D:\\22").listFiles(File::isFile);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    // 获取一个文件夹下的所有文件
    @Test
    public void fileTestDemo2() {
        File[] files = new File("D:\\22").listFiles(File::isFile);
        for (File file : files) {
            System.out.println(file.getFreeSpace());
        }
    }

    @Test
    public void fileReadTestDemo() {
        List<String> lists = FileUtils.getFileToList("C:\\Users\\octopus\\Desktop\\sku_info.csv");

        List<String> newList = new ArrayList<>();
        for (String str : lists) {
            int randomNumber = RandomUtils.intSeed(0, 9);
            str = str + "," + randomNumber;
            newList.add(str);
        }
        FileUtils.listToFile("C:\\Users\\octopus\\Desktop\\sku_info2.csv", newList);
    }

    @Test
    public void millist2Date() throws Exception {
        long milliSecond = 1555924579970l;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = null;
        try {
            Date date = new Date();
            date.setTime(milliSecond);
            String str = sdf.format(date);
            date2 = sdf.parse(str);
        } catch (Exception e) {

        }
        System.out.println(date2.getTime());
    }

    @Test
    public void Date2MilisTestDemo() {
        try {
            String times = "2019-05-23 04:00:00";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(times);
            System.out.println(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mapToList() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("zhangyu", 23l);
        List<String> list = map2List(map);
        listToFile("d:\\map.csv", list);
    }

    private List<String> map2List(HashMap<String, Long> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue();
            list.add(str);
        }
        return list;
    }

    public static void listToFile(String filePath, List<String> infoList) {
        try {
            File filename = new File(filePath);
            org.apache.commons.io.FileUtils.writeLines(filename, infoList, true);
            long sizeOf = org.apache.commons.io.FileUtils.sizeOf(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
