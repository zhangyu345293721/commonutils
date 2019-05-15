package com.zhang.readjson.demo;

/**
 * @program: utilsdemo
 * @description: person的bean
 * @author: zhangyu
 * @create: 2019-05-14 18:56
 */
public class Person {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public String getSex() {
        return sex;
    }


    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", sex='" + sex + '\'' + ", age=" + age + '}';
    }
}
