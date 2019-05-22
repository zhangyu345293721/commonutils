package com.zhang.readjson.demo;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @program: utilsdemo
 * @description: java将bean的数据写入到json当中 (使用阿里的fastjson包)
 * @author: zhangyu
 * @create: 2019-05-22 15:34
 */
public class WriteJson {
    @Test
    public void entityToJson() throws Exception {
        Person user = new Person("zhangyu", "male", 19);
        String text = JSON.toJSONString(user);
        System.out.println(text);
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
