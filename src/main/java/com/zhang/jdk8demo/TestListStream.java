package com.zhang.jdk8demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description: 测试ListStream值
 * @author: zhangyu
 * @create: 2019-05-29 18:20
 */
public class TestListStream {
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
