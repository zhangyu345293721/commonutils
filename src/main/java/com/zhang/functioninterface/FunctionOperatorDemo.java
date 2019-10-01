package com.zhang.functioninterface;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @program: utilsdemo
 * @description: 测试Operator类
 * @author: zhangyu
 * @create: 2019-09-27 13:34
 */
public class FunctionOperatorDemo {

    @Test
    public void fun1() {
        UnaryOperator<String> unaryOperator = greet -> greet + " Bob!";
        System.out.println(unaryOperator.apply("Hello!"));
    }

    @Test
    public void fun2() {
        UnaryOperator<String> unaryOperator = greet -> greet + " Bob!";
        UnaryOperator<String> unaryOperator1 = greet -> greet + " Jack!";
        String greet = unaryOperator.andThen(unaryOperator1).apply("Hello!");
        System.out.println(greet);
    }

    @Test
    public void fun3() {
        UnaryOperator<String> unaryOperator = greet -> greet + " Bob!";
        UnaryOperator<String> unaryOperator1 = greet -> greet + " Jack!";
        String greet = unaryOperator.compose(unaryOperator1).apply("Hello");
        System.out.println(greet);
    }

    @Test
    public void fun4() {
        BinaryOperator<String> binaryOperator = (flag, flag1) -> flag + flag1;
        System.out.println(binaryOperator.apply("Hello", "Jack")); // Hello Jack!!
        Function<String, String> function = a -> a + "!!!";
        System.out.println();
    }
}
