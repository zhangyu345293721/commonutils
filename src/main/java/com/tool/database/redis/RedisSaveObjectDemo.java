package com.tool.database.redis;


import com.tool.bean.Person;
import com.tool.database.redis.redisserializable.SerializeObjectTool;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author: zhangyu
 */
public class RedisSaveObjectDemo {
    @Test
    public void redisObjectTest() {
        Jedis redis = new Jedis("172.16.8.90", 6379);
        redis.auth("root");
        // 存对象
        Person p = new Person(); // peson类记得实现序列化接口 Serializable

        p.setAge(26);
        p.setUserName("zhangyu");
        p.setPassword("123456");
        byte[] personByte = SerializeObjectTool.serialize(p);
        redis.set("person".getBytes(), personByte);

        // 取对象
        byte[] byt = redis.get("person".getBytes());
        Object obj = SerializeObjectTool.unserizlize(byt);
        // 获取对象
        if (obj instanceof Person) {
            System.out.println(((Person) obj).getUserName());
            System.out.println(((Person) obj).getPassword());
            System.out.println(((Person) obj).getAge());
        }
    }
}
