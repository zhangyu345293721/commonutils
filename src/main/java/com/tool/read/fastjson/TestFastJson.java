package com.tool.read.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tool.base.file.FileUtils;
import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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


    // 实体变成json
    @Test
    public void entityToJson() {
        Person person = new Person("zhangyu", "male", 19);
        String text = JSON.toJSONString(person);
        System.out.println(text);
    }

    private List<Person> personList;

    {
        Person person1 = new Person("zhangyu", "male", 19);
        Person person2 = new Person("lisi", "female", 23);
        Person person3 = new Person("wangwu", "female", 21);
        Person person4 = new Person("zhaoliu", "male", 24);

        personList = new ArrayList<>();
        personList.addAll(Arrays.asList(person1, person2, person3, person4));
    }

    // 测试map变成json，json变成map
    @Test
    public void jsonToMapTestDemo() {

        Map<String, Person> map = personList.stream().collect(Collectors.toMap(Person::getUserName, e -> e));
        String str = JSON.toJSONString(map);

        Map<String, Object> personMap = JSONObject.parseObject(str, Map.class);
        Map<String, Person> newPersonMap = new HashMap<>();
        personMap.forEach((k, v) -> newPersonMap.put(k, JSONObject.parseObject(v.toString(), Person.class)));

        System.out.println(newPersonMap.toString());
    }

    // 将list变成json,json变成list
    @Test
    public void list2JsonTestDemo() {
        // 对象变成字符串
        String str = JSON.toJSONString(personList);
        // json变成对象
        List<Object> objects = JSONObject.parseObject(str, List.class);
        List<Person> personList1 = new ArrayList<>();
        objects.stream().forEach(e -> personList1.add(JSONObject.parseObject(e.toString(), Person.class)));
        System.out.println(personList1);
    }
}
