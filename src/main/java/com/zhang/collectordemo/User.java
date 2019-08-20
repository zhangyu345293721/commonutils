package com.zhang.collectordemo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

/**
 * @program: utilsdemo
 * @description: 测试User
 * @author: zhangyu
 * @create: 2019-06-19 18:35
 */

@Data
public class User {
    private String name;
    private int age;

    private Long id;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
