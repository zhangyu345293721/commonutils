package com.tool.python;

import jep.Interpreter;
import jep.JepException;
import jep.NDArray;
import jep.SharedInterpreter;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * 测试运算符
 *
 * @author: zhangyu
 */
public class ExecPython {
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

    @Test
    public void javaForPython() {
        try (Interpreter interp = new SharedInterpreter()) {
            // interp.exec("importing the java.lang.Class objects");
            interp.exec("from java.lang import System");
            interp.exec("from java.util import HashMap");
            interp.exec("from java.util import ArrayList as AL");
            interp.exec("x = HashMap()");
            interp.exec("y = HashMap(100)");
            interp.exec("y.put('a',1)");
            interp.exec("a = AL()");
            interp.exec("System.out.println(y.size())");
            Object result = interp.getValue("y");
            if (result instanceof Map) {
                System.out.println(result.toString());
            }

        } catch (JepException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void javaForPython2() {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("from java.lang import System");
            interp.exec("from java.util import ArrayList, HashMap");
            interp.exec("a = ArrayList()");
            interp.exec("a.add(\"abc\")");
            interp.exec("a += [\"def\"]");
            interp.exec("print(a)");
            interp.exec("System.out.println(a)");
        } catch (JepException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void javaForPython3() {
        try (Interpreter interp = new SharedInterpreter()) {
            float[] f = new float[]{1.0f, 2.1f, 3.3f, 4.5f, 5.6f, 6.7f};
            NDArray<float[]> nd = new NDArray<>(f, 3, 2);
            interp.set("x", nd);
            // System.out.println(nd.);
        } catch (JepException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void javaForPython4() {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("import numpy as np");
            int a = 9;
            interp.set("a", a);
            interp.exec("x = np.sqrt(a)");
            Object result1 = interp.getValue("x");
            System.out.println(result1);
            // System.out.println(nd.);
        } catch (JepException e) {
            e.printStackTrace();
        }
    }
}