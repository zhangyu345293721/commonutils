package com.tool.readfile.filedemo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: utilsdemo
 * @description: 测试文件夹是不是存在, 不存在就新建一个
 * @author: zhangyu
 * @create: 2019-05-23 10:04
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
    public void fun2() {
        String path = "D:\\var\\geekplus\\playback\\logTempDir";
        List<String> paths = getFilesPath(path);
        System.out.println(paths);
    }

    /**
     * @Author：zhangyu
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件
     * @Date：2019.7.15
     */
    public static List<String> getFilesPath(String path) {
        List<String> filesPath = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                filesPath.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return filesPath;
    }
}
