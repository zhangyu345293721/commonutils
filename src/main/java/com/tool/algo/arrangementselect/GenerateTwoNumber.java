package com.tool.algo.arrangementselect;

import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Permutation;

import java.util.*;

/**
 * @program: utilsdemo
 * @description: 产生两个不同的数字
 * @author: zhangyu
 * @create: 2019-09-26 14:18
 */
public class GenerateTwoNumber {

    @Test
    public void fun() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        int randomIndex1 = 0;
        int randomIndex2 = 0;
        Random random = new Random();
        while (randomIndex1 == randomIndex2) {
            randomIndex1 = random.nextInt(list.size());
            randomIndex2 = random.nextInt(list.size());
        }
        Collections.swap(list, randomIndex1, randomIndex2);
        System.out.println(list);
    }

    @Test
    public void getPermutationFun() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<List<String>> newList = new ArrayList<>();
        for (List<String> p : Permutation.of(list)) {
            System.out.println(p);
            newList.add(new ArrayList<>(p));
        }
        System.out.println(newList);
    }

    @Test
    public void sortMap() {

    }
}
