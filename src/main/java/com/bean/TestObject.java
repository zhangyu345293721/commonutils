package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: zhangyu
 */

@Data
@AllArgsConstructor
public class TestObject {
    private String name;
    private String sex;
    private Integer age;
    private String mail;
    private Boolean flag;
}
