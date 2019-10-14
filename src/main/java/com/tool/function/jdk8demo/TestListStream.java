package com.tool.function.jdk8demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试ListStream值
 *
 * @author: zhangyu
 */
public class TestListStream {
    // 利用stream对list进行过滤
    @Test
    public void fun() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.stream().filter(e -> e > 2).forEach(r -> System.out.println(r));
    }
}
