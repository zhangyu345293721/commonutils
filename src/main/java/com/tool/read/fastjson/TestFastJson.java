package com.tool.read.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tool.base.file.FileUtils;
import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

/**
 * 测试fastjson
 *
 * @author: zhangyu
 */
public class TestFastJson {
    // 测试fastJson解析数据
    @Test
    public void fun() {
        String json = "{\"code\":0,\"message\":\"没有查询到数据\",\"data\":null,\"taskId\":\"0-bb03193f-ed1f-4d32-8351-6538d329b26e\",\"time\":\"2017-09-2210:11:30\"}";
        JSONObject obj = JSONObject.parseObject(json);
        Integer code = obj.getInteger("code");
        String message = obj.getString("message");
        String taskId = obj.getString("taskId");
        System.out.println("code:" + code + ", message:" + message + ", taskId:" + taskId);
    }


    // 测试文件转成bean对象
    @Test
    public void JsonToEntity() {
        String path = "C:\\Users\\octopus\\Desktop\\person.json";
        String data = FileUtils.getFile2String(path);
        Person person = JSON.parseObject(data, Person.class);
        System.out.println(person.toString());
    }


    @Test
    public void entityToJson() {
        Person person = new Person("zhangyu", "male", 19);
        String text = JSON.toJSONString(person);
        System.out.println(text);
    }
}
