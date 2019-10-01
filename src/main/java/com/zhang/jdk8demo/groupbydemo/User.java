package com.zhang.jdk8demo.groupbydemo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * user的bean
 *
 * @author: zhangyu
 */

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
}
