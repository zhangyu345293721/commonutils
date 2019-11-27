package com.tool.python;

import jep.Interpreter;
import jep.JepException;
import jep.SharedInterpreter;

public class TestArr {
    public static void main(String[] args) {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("import sys");
            interp.exec("sys.path.append('.')");
            interp.exec("from my_module import *");
            int arr[][] = {{2, 2}, {2, 2}};

            interp.set("arr", arr);
            interp.exec("x =add(arr)");
            Object result1 = interp.getValue("x");
            int[][] newArr = null;
            if (result1 instanceof int[][]) {
                newArr = (int[][]) result1;
            }

            System.out.println(result1);
            for (int i = 0; i < newArr.length; i++) {
                for (int j = 0; j < newArr.length; j++) {
                    System.out.print(newArr[i][j] + " ");
                }
                System.out.println();
            }
        } catch (JepException je) {
            System.out.println(je.getMessage());
        }
    }
}
