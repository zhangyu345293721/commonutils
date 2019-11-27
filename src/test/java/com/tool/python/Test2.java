package com.tool.python;

import jep.Interpreter;
import jep.JepException;
import jep.NDArray;
import jep.SharedInterpreter;

public class Test2 {
    public static void main(String[] args) {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("import sys");
            interp.exec("sys.path.append('.')");
            interp.exec("import my_module2");
            NDArray<float[]> nd = getNdarray();
            interp.set("nd", nd);
            interp.exec("x = my_module2.my_add(nd)");
            Object result1 = interp.getValue("x");
            NDArray<float[]> ndArray = null;
            if (result1 instanceof NDArray) {
                ndArray = (NDArray<float[]>) result1;
            }
            for (float num : ndArray.getData()) {
                System.out.print(num + " ");
            }
        } catch (JepException je) {
            System.out.println(je.getMessage());
        }
    }

    /**
     * 生成ndarray
     *
     * @return ndarray数组
     */
    public static NDArray<float[]> getNdarray() {
        float[] f = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
        NDArray<float[]> nd = new NDArray<>(f, 3, 2);
        for (int n : nd.getDimensions()) {
            System.out.println(n);
        }
        System.out.println("================================================");
        return nd;
    }
}
