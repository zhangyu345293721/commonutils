package com.tool.database.redis;


import com.alibaba.fastjson.JSON;
import com.tool.bean.Person;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhangyu
 */
public class RedisSaveListDemo {
    private List<Person> personList = new ArrayList<>();

    {
        Person p1 = new Person();
        p1.setAge(19);
        p1.setPassword("12345");
        p1.setUserName("zhangyu");

        Person p2 = new Person();
        p2.setAge(29);
        p2.setPassword("hhahah");
        p2.setUserName("lisi");

        personList.add(p1);
        personList.add(p2);
    }

    @Test
    public void redisSaveList() {
        Jedis redis = new Jedis("172.16.8.90", 6379);
        redis.auth("root");
        // list变成map
        Map<String, Person> map = personList.stream().collect(Collectors.toMap(Person::getUserName, e -> e));
        String personsInfo = JSON.toJSONString(map);
        System.out.println(personsInfo);
        redis.set("personsInfo", personsInfo);
        System.out.println(personsInfo);

        Map<String, Object> map1 = JSON.parseObject(personsInfo, Map.class);
        Map<String, Person> personMap = new HashMap<>();
        map1.forEach((k, v) -> personMap.put(k, JSON.parseObject(v.toString(), Person.class)));

        for (String s : personMap.keySet()) {
            System.out.println(personMap.get(s) instanceof Person);
        }
    }

    @Test
    public void getPersonsInfo() {
        Jedis redis = new Jedis("172.16.8.90", 6379);
        redis.auth("root");
        String personsInfo = redis.get("personsInfo");
        System.out.println(personsInfo);
    }
}
