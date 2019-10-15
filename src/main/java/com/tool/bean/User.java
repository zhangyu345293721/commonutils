package com.tool.bean;

import lombok.Data;

/**
 * 测试User
 * @author: zhangyu
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
