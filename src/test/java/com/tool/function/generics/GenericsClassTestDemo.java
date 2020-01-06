package com.tool.function.generics;

import org.junit.jupiter.api.Test;

/**
 * 测试泛型类
 *
 * @author: zhangyu
 */
public class GenericsClassTestDemo {

    // 测试泛型方法
    @Test
    public void GenericsTestDemo() {
        GenericsClass genericsClass1 = new GenericsClass(12, "zhangyu");
        System.out.println(genericsClass1.toString());
        GenericsClass genericsClass2 = new GenericsClass("12", 12324);
        System.out.println(genericsClass2.toString());
        GenericsClass genericsClass3 = new GenericsClass("12", "zhangyu");
        System.out.println(genericsClass3.toString());
    }
}
