package com.tool.map;

/**
 * 读取配置文件
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
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
            System.out.println("url:" + properties.getProperty("url"));
            System.out.println("username:" + properties.getProperty("username"));
            System.out.println("password:" + properties.getProperty("password"));
            System.out.println("databases:" + properties.getProperty("databases"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LoadProperties loadProperties = new LoadProperties();
        loadProperties.loadProperties();
    }
}
