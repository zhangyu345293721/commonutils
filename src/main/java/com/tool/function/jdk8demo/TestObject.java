package com.tool.function.jdk8demo;

import lombok.Data;

/**
 * @author: zhangyu
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
