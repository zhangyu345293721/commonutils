package com.tool.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user类
 *
 * @author: zhangyu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;

    public User(String name, int age) {
        this.userName = name;
        this.age = age;
    }
}