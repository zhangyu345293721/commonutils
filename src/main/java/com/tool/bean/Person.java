package com.tool.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: utilsdemo
 * @description:
 * @author: zhangyu
 * @create: 2019-08-12 11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    public String userName;
    public String password;
    public int age;
}
