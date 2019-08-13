package com.zhang.collectordemo;

import lombok.Data;

/**
 * @program: utilsdemo
 * @description: pojo的测试类
 * @author: zhangyu
 * @create: 2019-06-18 13:51
 */

@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
