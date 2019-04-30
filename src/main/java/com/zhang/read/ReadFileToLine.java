package com.zhang.read;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.List;

/**
 * @program: utilsdemo
 * @description: 把文件读到list当中
 * @author: zhangyu
 * @create: 2019-04-30 18:25
 */
public class ReadFileToLine {
    /**
     * @Description: 将文件每行读入到list当中
     * @Param: String path 文件的路径
     * @return: List<String> 存储文件每行数据的list
     * @Author: zhangyu
     */

    public static List<String> getFileToList(String filePath) {
        List<String> readFileList = null;
        try {
            readFileList = FileUtils.readLines(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readFileList;
    }
}
