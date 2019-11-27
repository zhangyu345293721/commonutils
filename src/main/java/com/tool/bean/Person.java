package com.tool.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * person的bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    public String userName;
    public String password;
    public int age;
}
