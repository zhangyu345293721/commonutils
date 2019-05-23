package com.zhang.filedemo;

import org.junit.jupiter.api.Test;

import java.io.File;

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
}
