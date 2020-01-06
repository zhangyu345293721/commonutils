package com.tool.function.function;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

/**
 * 测试Function功能
 *
 * @author: zhangyu
 */
public class FunctionSupplierDemo {

    @Test
    public void addStringTestDemo() {
        Supplier<String> supplier = () -> "Hello Jack!";
        System.out.println(supplier.get());
    }

    @Test
    public void fetchFlagTestDemo() {
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean()); // true
    }

    @Test
    public void getANumberTestDemo() {
        DoubleSupplier doubleSupplier = () -> 2.7;
        System.out.println(doubleSupplier.getAsDouble());// 2.7
    }
}
