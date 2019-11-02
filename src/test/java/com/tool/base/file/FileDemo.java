package com.tool.base.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

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
}
