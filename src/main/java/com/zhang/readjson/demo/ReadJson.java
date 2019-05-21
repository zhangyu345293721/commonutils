package com.zhang.readjson.demo;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @program: hephaestus
 * @description: java读取json数据 (使用阿里的fastjson包)
 * @author: zhangyu
 * @create: 2019-05-14 18:34
 */
public class ReadJson {
    @Test
    public void JsonToEntity() throws Exception {
        String jsonString = fileRead();
        //String jsonString = "{\"name\":\"张三\",\"sex\":\"男\",\"age\":25}";
        Person person = JSON.parseObject(jsonString, Person.class);
        System.out.println(person.toString());
    }

    /**
     * @Description: 文件读出成为字符串的形式
     * @Param: 无参数
     * @return: 返回值为String类型
     * @Author: zhangyu
     */
    public String fileRead() throws Exception {
        File file = new File("C:\\Users\\octopus\\Desktop\\person.json");
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s);
            // System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        // System.out.println(str );
        return str;
    }
}
