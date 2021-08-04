package com.tool.split;

import com.google.common.base.Splitter;
import com.tool.base.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyu
 */
public class SplitDemo {
    @Test
    public void splitTestDemo() {
        String path = "C:\\Users\\octopus\\Desktop\\beetle929\\output.txt";
        List<String> list = FileUtils.getFileToList(path);
        String line = list.get(0);
        Iterable<String> result = Splitter.on("\\n").split(line);
        List<String> tempList = new ArrayList<>();
        for (String s : result) {
            tempList.add(s);
        }
        System.out.println(tempList.size());
    }


    /**
     * 字符串切割:
     */
    @Test
    public void splitTestDemo2() {
        String path = "C:\\Users\\octopus\\Desktop\\beetle929\\output.txt";
        List<String> list = FileUtils.getFileToList(path);
        String line = list.get(0);
        System.out.println(line);
        String[] strs = line.split("\\n");
        System.out.println(strs.length);
    }
}
