package com.tool.algo.arrangementselect;

import org.junit.jupiter.api.Test;

/**
 * 复数相乘
 *
 * @author: zhangyu
 */
public class ComplexNumber537 {
    @Test
    public void complexTestDemo() {
        String a = "-11+-30i";
        String b = "55+-69i";
        // String a = "1+-1i";
        // String b = "1+-1i";
        String result = complexNumberMultiply2(a, b);
        System.out.println("result = " + result);
    }

    public String complexNumberMultiply(String a, String b) {
        if (a.contains("+-") && b.contains("+-")) {
            String[] strsA = a.split("\\+-");
            int numA = Integer.valueOf(strsA[0]);
            int iA = Integer.valueOf(strsA[1].substring(0, strsA[1].length() - 1));
            String[] strsB = a.split("\\+-");
            int numB = Integer.valueOf(strsB[0]);
            int iB = Integer.valueOf(strsB[1].substring(0, strsB[1].length() - 1));
            int result1 = numA * numB;
            int reuslt2 = -numA * iB;
            int result3 = -iA * numB;
            int result4 = iA * iB;
            return (result1 - result4) + "+" + (reuslt2 + result3) + "i";
        } else if (a.contains("+") && b.contains("+")) {
            String[] strsA = a.split("\\+");
            int numA = Integer.valueOf(strsA[0]);
            int iA = Integer.valueOf(strsA[1].substring(0, strsA[1].length() - 1));
            String[] strsB = b.split("\\+");
            int numB = Integer.valueOf(strsB[0]);
            int iB = Integer.valueOf(strsB[1].substring(0, strsB[1].length() - 1));
            int result1 = numA * numB;
            int reuslt2 = numA * iB;
            int result3 = iA * numB;
            int result4 = iA * iB;
            return (result1 - result4) + "+" + (reuslt2 + result3) + "i";

        } else if (a.contains("+") && b.contains("+-")) {
            String[] strsA = a.split("\\+");
            int numA = Integer.valueOf(strsA[0]);
            int iA = Integer.valueOf(strsA[1].substring(0, strsA[1].length() - 1));
            String[] strsB = b.split("\\+-");
            int numB = Integer.valueOf(strsB[0]);
            int iB = Integer.valueOf(strsB[1].substring(0, strsB[1].length() - 1));
            int result1 = numA * numB;
            int reuslt2 = numA * iB;
            int result3 = iA * numB;
            int result4 = iA * iB;
            return (result1 - result4) + "+" + (reuslt2 + result3) + "i";
        } else {
            String[] strsA = a.split("\\+-");
            int numA = Integer.valueOf(strsA[0]);
            int iA = Integer.valueOf(strsA[1].substring(0, strsA[0].length() - 1));
            String[] strsB = b.split("\\+");
            int numB = Integer.valueOf(strsB[0]);
            int iB = Integer.valueOf(strsB[1].substring(0, strsB[1].length() - 1));
            int result1 = numA * numB;
            int reuslt2 = numA * iB;
            int result3 = iA * numB;
            int result4 = iA * iB;
            return (result1 - result4) + "+" + (reuslt2 + result3) + "i";
        }
    }

    public String complexNumberMultiply2(String a, String b) {
        String[] strsA = a.split("\\+");
        int numA = Integer.valueOf(strsA[0]);
        int iA = Integer.valueOf(strsA[1].substring(0, strsA[0].length()));
        String[] strsB = b.split("\\+");
        int numB = Integer.valueOf(strsB[0]);
        int iB = Integer.valueOf(strsB[1].substring(0, strsB[1].length()-1));
        int result1 = numA * numB;
        int reuslt2 = numA * iB;
        int result3 = iA * numB;
        int result4 = iA * iB;
        return (result1 + result4) + "+" + (reuslt2 + result3) + "i";
    }
}
