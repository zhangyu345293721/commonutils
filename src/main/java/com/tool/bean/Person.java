package com.tool.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * person的bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person  {
    public String userName;
    public String password;
    public int age;
}
