package com.tool.map;

/**
 * 读取配置文件
 * 读取文件流时候，在try后面处理，不用写finally来关闭流
 *
 * @author: zhangyu
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public void loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("config.properties")) {
            properties.load(inputStream);
            System.out.println("url:" + properties.getProperty("url"));
            System.out.println("username:" + properties.getProperty("username"));
            System.out.println("password:" + properties.getProperty("password"));
            System.out.println("databases:" + properties.getProperty("databases"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoadProperties loadProperties = new LoadProperties();
        loadProperties.loadProperties();
    }
}
