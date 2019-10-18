package com.tool.algo.arrangementselect;

import org.junit.jupiter.api.Test;
import org.raistlic.common.permutation.Permutation;

import java.util.*;

/**
 * 产生两个不同的数字
 *
 * @author: zhangyu
 */
public class ChangeTwoNumberIndex {

    // 交换两个元素的位置
    @Test
    public void changeListIndexTestDemo() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));

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
}
