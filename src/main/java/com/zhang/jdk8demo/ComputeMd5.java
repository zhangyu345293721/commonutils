package com.zhang.jdk8demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @program: utilsdemo
 * @description: 计算文件的md5值
 * @author: zhangyu
 * @create: 2019-05-29 19:24
 */
public class ComputeMd5 {
    @Test
    public void fun() {
        String s = getFileMD5Value("D:\\software\\f.txt");
        System.out.println(s.length());
    }

    /**
     * @Description: 通过传入文件，得到文件的地址
     * @Param: path:文件的地址
     * @return: 传递文件的md5, 得到文件的32位字符串
     * @Author: zhangyu
     */
    public static String getFileMD5Value(String path) {
        BigInteger bi = null;
        try {
            byte[] buffer = new byte[8192];
            int len = 0;
            MessageDigest md = MessageDigest.getInstance("MD5");
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            while ((len = fis.read(buffer)) != -1) {
                md.update(buffer, 0, len);
            }
            fis.close();
            byte[] b = md.digest();
            bi = new BigInteger(1, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bi.toString(16);
    }
}
