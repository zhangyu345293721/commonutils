package com.tool.map;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

/**
 * property使用
 *
 * @author: zhangyu
 */
public class TestProperties {
    public void writeProperties() {
        Properties properties = new Properties();
        try (OutputStream output = new FileOutputStream("config.properties");) {
            properties.setProperty("url", "jdbc:mysql://localhost:3306/");
            properties.setProperty("username", "root");
            properties.setProperty("password", "root");
            properties.setProperty("databases", "music_player");
            properties.store(output, "zhangyu modify" + new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestProperties t = new TestProperties();
        t.writeProperties();
    }
}
