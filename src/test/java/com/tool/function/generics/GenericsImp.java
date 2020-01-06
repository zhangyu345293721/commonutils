package com.tool.function.generics;

import org.junit.jupiter.api.Test;

/**
 * 实现泛型接口
 *
 * @author: zhangyu
 */

public class GenericsImp implements GenericsInterface<Integer> {
    @Override
    public Integer print() {
        return 2;
    }

    // 测试泛型接口
    @Test
    public void GenericsImpTestDemo() {
        System.out.println(print());
    }
}
