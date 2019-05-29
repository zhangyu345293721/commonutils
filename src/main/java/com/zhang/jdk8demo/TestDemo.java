package com.zhang.jdk8demo;

import org.junit.jupiter.api.Test;

/**
 * @program: utilsdemo
 * @description: 测试运算符
 * @author: zhangyu
 * @create: 2019-05-29 11:35
 */
public class TestDemo {
    @Test
    public void fun() {
        if (true || false && false) {
            System.out.println("1");
        }
        if (false || true && true) {
            System.out.println("2");
        }
    }
}
