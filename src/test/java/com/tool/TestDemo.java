package com.tool;

import jep.Interpreter;
import jep.JepException;
import jep.SharedInterpreter;
import org.junit.jupiter.api.Test;

/**
 * 测试运算符
 *
 * @author: zhangyu
 */
public class TestDemo {
    @Test
    public static void main(String[] args) {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("from java.lang import System");
            interp.exec("s = 'Hello World'");
            interp.exec("System.out.println(s)");
            interp.exec("print(s)");
            interp.exec("print(s[1:-1])");
        } catch (JepException e) {
            e.printStackTrace();
        }
    }
}
