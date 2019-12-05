package com.tool.function.function;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * 测试Operator类
 *
 * @author: zhangyu
 */
public class FunctionOperatorDemo {
    private String NAME = " Bob!";

    @Test
    public void applyTestDemo() {
        UnaryOperator<String> unaryOperator = greet -> greet + NAME;
        System.out.println(unaryOperator.apply("Hello!"));
    }

    @Test
    public void andThenTestDemo() {
        UnaryOperator<String> unaryOperator = greet -> greet + NAME;
        UnaryOperator<String> unaryOperator1 = greet -> greet + " Jack!";
        String greet = unaryOperator.andThen(unaryOperator1).apply("Hello!");
        System.out.println(greet);
    }

    @Test
    public void composeTestDemo() {
        UnaryOperator<String> unaryOperator = greet -> greet + NAME;
        UnaryOperator<String> unaryOperator1 = greet -> greet + " Jack!";
        String greet = unaryOperator.compose(unaryOperator1).apply("Hello");
        System.out.println(greet);
    }

    @Test
    public void applyTestDemo2() {
        BinaryOperator<String> binaryOperator = (flag, flag1) -> flag + flag1;
        System.out.println(binaryOperator.apply("Hello", "Jack")); // Hello Jack!!
    }
}
