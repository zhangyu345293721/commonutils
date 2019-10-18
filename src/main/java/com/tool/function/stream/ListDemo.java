package com.tool.function.stream;

import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Permutation;

import java.math.BigInteger;
import java.util.*;

/**
 * @author: zhangyu
 */
public class ListDemo {

    @Test
    public void permutationTestDemo() {
        List<List<String>> newList = new ArrayList<>();
        for (List<String> list : Permutation.of(Arrays.asList("a", "b", "c"))) {
            newList.add(new ArrayList<>(list));
        }
        System.out.println(newList);
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
}
