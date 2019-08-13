package com.zhang.jdk8demo;

import lombok.Data;

/**
 * @program: utilsdemo
 * @description:
 * @author: zhangyu
 * @create: 2019-08-13 18:16
 */
@Data
public class TestObject {
    private String name;
    private String sex;
    private int age;
    private String email;
    private boolean isLeader;

    public TestObject() {
    }

    public TestObject(String name, String sex, int age, String email, boolean isLeader) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.isLeader = isLeader;
    }
}
