package com.tool.function.collector.testsort.collector.collectordemo;

import org.junit.jupiter.api.Test;

/**
 * @program: utilsdemo
 * @description: 测试三元表达式的测试
 * @author: zhangyu
 * @create: 2019-07-12 17:09
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
