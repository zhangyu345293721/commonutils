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
        Person person = new Person("zhangyu", "male", 19);
        String text = JSON.toJSONString(person);
        System.out.println(text);
    }
}
