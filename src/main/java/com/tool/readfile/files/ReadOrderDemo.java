package com.tool.readfile.files;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取数据文件
 *
 * @author: zhangyu
 */
public class ReadOrderDemo {
    @Test
    public void fun() {
        List<String> list = ReadFileToLine.getFileToList("C:\\Users\\octopus\\Desktop\\sql\\pick_order.csv");
        List<String> smallList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            StringBuffer sb = new StringBuffer();
            String[] strs = list.get(i).split("\\s+");
            for (int j = 0; j < strs.length; j++) {
                if (j == strs.length - 1) {
                    sb.append(strs[j]);
                } else {
                    sb.append(strs[j] + ",");
                }
            }
            smallList.add(sb.toString());
        }
        smallList.forEach(i -> System.out.println(i));
    }
}
