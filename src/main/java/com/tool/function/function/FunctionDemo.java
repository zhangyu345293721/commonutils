package com.tool.function.function;

import org.junit.jupiter.api.Test;

import java.util.function.*;

/**
 *  测试Function例子
 * @author: zhangyu
 */
public class FunctionDemo {

    @Test
    public void functionTestDemo1() {
        Function<Integer, Integer> test1 = i -> i + 1;
        Function<Integer, Integer> test2 = i -> i * i;
        System.out.println(calculate(test1, 5));
        System.out.println(calculate(test2, 5));
    }

    public static Integer calculate(Function<Integer, Integer> test, Integer number) {
        return test.apply(number);
    }

    @Test
    public void functionTestDemo2() {
        Function<Integer, Integer> A = i -> i + 1;
        Function<Integer, Integer> B = i -> i * i;
        // 测试function方法
        System.out.println("F1:" + B.apply(A.apply(5)));
        // compose操作
        System.out.println("F1:" + B.compose(A).apply(5));
        System.out.println("F2:" + A.apply(B.apply(5)));
        // andThen操作
        System.out.println("F2:" + B.andThen(A).apply(5));
        System.out.println(B.compose(A).compose(A).compose(A).andThen(A).apply(5));
    }

    @Test
    public void doubleFunction() {
        DoubleFunction<String> doubleFunction = doub -> "结果:" + doub;
        System.out.println(doubleFunction.apply(1.6));
    }

    @Test
    public void doubleToIntFunction() {
        DoubleToIntFunction doubleToIntFunction = doub -> Double.valueOf(doub).intValue();
        System.out.println(doubleToIntFunction.applyAsInt(1.2));
    }

    @Test
    public void toDoubleBiFunction() {
        ToDoubleBiFunction<Long, Float> toDoubleBiFunction = (lon, floa) -> lon.doubleValue() + floa.doubleValue();
        System.out.println(toDoubleBiFunction.applyAsDouble(11L, 235.5f));

    }

    @Test
    public void toDoubleFunction() {
        ToDoubleFunction<Float> toDoubleFunction = floa -> floa.doubleValue();
        System.out.println(toDoubleFunction.applyAsDouble(12345f));
    }
}
