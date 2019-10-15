package com.tool;

import org.junit.jupiter.api.Test;

/**
 * 测试三元表达式的测试
 *
 * @author: zhangyu
 */
public class Demo {
    @Test
    public void fun() {
        int a = 2;
        if (a > 1) {
            System.out.println("a>1");
        } else {
            System.out.println("a<=1");
        }
    }

    @Test
    public void fun2() {
        int a = 2;
        System.out.println(a > 1 ? "a>1" : "a<=1");
    }

    @Test
    public void fun3() {
        int a = 2;
        System.out.println(a > 1 ? "a>1" : "a<=1");
    }

    @Test
    public void fun4() {
        int a = 2;
        System.out.println(a > 1 ? "a>1" : "a<=1");
    }
}
