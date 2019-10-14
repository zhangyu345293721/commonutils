package com.tool.readfile.files;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * 读取Gz压缩文件成list
 *
 * @author: zhangyu
 */
public class GZFiletoList {
    /**
     * 将.gz压缩文件每行读入到list当中
     *
     * @param: String path 文件的路径
     * @return: List<String> 存储文件每行数据的list
     */
    public static List<String> getGzFileToList(String filePath) {
        InputStream in = null;
        List<String> linesList = null;
        try {
            in = new GZIPInputStream(new FileInputStream(filePath));
            linesList = IOUtils.readLines(in, Charsets.toCharset("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
        return linesList;
    }

    /*@Test
    public void fun() {
        String path = ";
        List<String> list = getGzFileToList(path);
        // System.out.println(list.size());
    }*/
}
