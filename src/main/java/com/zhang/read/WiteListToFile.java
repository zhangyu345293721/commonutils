package com.zhang.read;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * @program: utilsdemo
 * @description: 把list数据转换为文件
 * @author: zhangyu
 * @create: 2019-04-30 18:28
 */
public class WiteListToFile {
    /**
     * @Description: 将list里面数据写入到文件
     * @Param: String filePath 文件要保存的路径 List<String > infoList 保存信息的list
     * @return:
     * @Author: zhangyu
     */
    public static void listToFile(String filePath, List<String> infolist) {
        try {
            File filename = new File(filePath);
            FileUtils.writeLines(filename, infolist, true);
            long sizeOf = FileUtils.sizeOf(new File(filePath));
            // System.out.println(sizeOf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
