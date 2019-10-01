package com.zhang.functioninterface;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

/**
 * @program: utilsdemo
 * @description: 测试functionsupplier
 * @author: zhangyu
 * @create: 2019-09-27 13:26
 */
public class FunctionSupplierDemo {

    @Test
    public void fun() {
        Supplier<String> supplier = () -> "Hello Jack!";
        System.out.println(supplier.get());
    }

    @Test
    public void fun2() {
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean()); // true
    }

    @Test
    public void fun3() {
        DoubleSupplier doubleSupplier = () -> 2.7;
        System.out.println(doubleSupplier.getAsDouble());// 2.7
    }
}
