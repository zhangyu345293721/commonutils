package com.tool.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhangyu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestObject {
    private String name;
    private String sex;
    private int age;
    private String email;
    private boolean isLeader;

}
