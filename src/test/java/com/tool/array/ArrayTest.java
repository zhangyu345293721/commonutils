package com.tool.array;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 测试单调栈
 *
 * @author: zhangyu
 */
public class ArrayTest {
    @Test
    public void testArray() {
        int[] arr = {4, 2, 1};
        Stack<Integer> stack = getDecreaseStack(arr);
        System.out.println(stack);
    }

    /**
     * 自增栈
     *
     * @param arr 数组
     * @return 增加栈
     */
    public Stack<Integer> getDecreaseStack(int[] arr) {
        if (arr == null) {
            return new Stack<>();
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            while (!stack.isEmpty() && num > stack.peek()) {
                stack.pop();
            }
            stack.push(num);
        }
        return stack;
    }

    /**
     * 自增栈
     *
     * @param arr 数组
     * @return 增加栈
     */
    public Stack<Integer> getIncreaseStack(int[] arr) {
        if (arr == null) {
            return new Stack<>();
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            while (!stack.isEmpty() && num < stack.peek()) {
                stack.pop();
            }
            stack.push(num);
        }
        return stack;
    }

    @Test
    public void arrayTest2() {
        int i = 0, j = 0, k = 0;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void arrayTest3() {
        int a = 0, b = 0;
        a = a++;
        b = a++;
        System.out.println(a);
        System.out.println(b);
    }
}
