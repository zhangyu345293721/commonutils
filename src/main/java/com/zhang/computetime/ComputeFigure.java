package com.zhang.computetime;

import org.junit.jupiter.api.Test;

/**
 * 计算数字
 *
 * @author: zhangyu
 */
public class ComputeFigure {
    @Test
    public void fun() {

        int a = 0;
        int b = 0;
        int c = 0;
        for (a = 1; a <= 1000; a++) {
            for (b = 1; b <= 1000; b++) {
                for (c = 1; c <= 1000; c++) {
                    if (Math.pow(a, 2) + Math.pow(b, 3) == Math.pow(c, 4)) {
                        System.out.println(a + ":" + b + ":" + c);
                    }
                }
            }
        }
    }
}
