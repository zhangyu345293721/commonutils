package com.tool.database.redis;

import com.tool.database.redis.redisserializable.SerializeObjectTool;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * 测试Redis
 * @author: zhangyu
 */
public class RedisConnectionDemo {
    @Test
    public void fun() {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
         /*  //这里要求的是map必须是key和value都是string类型的
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangyu");
        map.put("age", "13");
        map.put("sex", "男");
        map.put("height", "174");

        byte[] info = SerializeObjectTool.serialize(map);
        //调用jedis的hmset(存入hash map)的方法将map的键值对存进去
        jedis.set("people".getBytes(), info);*/
        byte[] obj = jedis.get("people".getBytes());
        Object o = SerializeObjectTool.unserizlize(obj);

        if (o instanceof Map) {
            String name = ((Map<String, String>) o).get("name");
            System.out.println(name);
        }
    }

    @Test
    public void connectRemoteRedis() {
        Jedis jedis = new Jedis("47.110.134.125", 6379);
        jedis.auth("123sjzl123");
        System.out.println("Connet to Redis-Server Successfully");
        String name = jedis.get("name");
        System.out.println("name :" + name);
    }

    @Test
    public void connectRemoteRedis2() {
        Jedis jedis = new Jedis("172.16.8.90", 6379);
        jedis.auth("root");
        System.out.println("Connet to Redis-Server Successfully");
        jedis.set("name", "zhangyu");
        String name = jedis.get("name");
        System.out.println("name :" + name);
    }
}
