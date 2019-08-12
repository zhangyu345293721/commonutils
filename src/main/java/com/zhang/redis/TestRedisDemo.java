package com.zhang.redis;

import com.zhang.redis.redisserializable.SerializeObjectTool;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import java.util.Map;

/**
 * @program: utilsdemo
 * @description: 测试Redis
 * @author: zhangyu
 * @create: 2019-08-12 14:40
 */
public class TestRedisDemo {
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
}
