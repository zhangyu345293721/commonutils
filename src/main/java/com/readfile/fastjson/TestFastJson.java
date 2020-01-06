package com.readfile.fastjson;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * @program: utildemos
 * @description: 测试fastjson
 * @author: zhangyu
 * @create: 2019-06-18 11:19
 */
public class TestFastJson {
    @Test
    public void fun() {
        String json = "{\"code\":0,\"message\":\"没有查询到数据\",\"data\":null,\"taskId\":\"0-bb03193f-ed1f-4d32-8351-6538d329b26e\",\"time\":\"2017-09-2210:11:30\"}";
        JSONObject obj = JSONObject.parseObject(json);
        Integer code = obj.getInteger("code");
        String message = obj.getString("message");
        String taskId = obj.getString("taskId");
        System.out.println("code:" + code + ", message:" + message + ", taskId:" + taskId);
    }
}
