package com.tool.string;

import org.junit.jupiter.api.Test;

/**
 * 计算机运行时候问题
 *
 * @author: zhangyu
 */
public class RuntimeDemo {

    @Test
    public void runtimeTestDemo() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        System.out.println(maxMemory);
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long totalFreeMemory = freeMemory + (maxMemory - allocatedMemory);
        long usedMemory = maxMemory - totalFreeMemory;
        System.out.println(usedMemory);
    }
}
