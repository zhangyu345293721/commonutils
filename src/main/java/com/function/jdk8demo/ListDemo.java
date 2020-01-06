package com.function.jdk8demo;

import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Permutation;

import java.math.BigInteger;
import java.util.*;

/**
 * @author: zhangyu
 */
public class ListDemo {

    // 对链表的位置进行交换
    @Test
    public void swapListIndexDemo() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        Collections.swap(list, 0, list.size() - 1);
        System.out.println(list);
    }

    @Test
    public void permutationTestDemo() {
        for (List<String> list : Permutation.of(Arrays.asList("a", "b", "c"))) {
            System.out.println(list);
        }
    }

    @Test
    public void permutationTestDemo2() {
        System.out.println(Permutation.of(Arrays.asList("a", "b", "c"), 3).iterator());
        Iterator iter = Permutation.of(Arrays.asList("a", "b", "c"), 3).iterator();
        List<List<String>> list = new ArrayList<>();
        BigInteger b = Permutation.of(Arrays.asList("a", "b", "c")).getPermutationCount();
        System.out.println(b);
        while (iter.hasNext()) {
            List<String> oneList = (List<String>) iter.next();
            System.out.println(list.add(oneList));
        }
        System.out.println(list);
    }
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
