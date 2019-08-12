package com.zhang.redis.redisserializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: utilsdemo
 * @description:
 * @author: zhangyu
 * @create: 2019-08-12 11:57
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    public String userName;
    public String password;
    public int age;
}
