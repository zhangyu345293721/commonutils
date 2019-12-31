package com.tool.algo.computetime;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出两个字符串的最大公约字符串
 *
 * @author: zhangyu
 */
public class GreatestCommonDivisor1071 {
    @Test
    public void greatestStringTestDemo() {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        String maxDivideStr = gcdOfStrings(str1, str2);
        System.out.println("maxDivideStr = " + maxDivideStr);
    }

    /**
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最大公字符串
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str1.length() < 1) {
            return "";
        }
        if (str2 == null || str2.length() < 1) {
            return "";
        }
        if (str2.equals(str1)) {
            return str1;
        }
        String shortStr = "";
        String longStr = "";
        if (str1.length() > str2.length()) {
            shortStr = str2;
            longStr = str1;
        } else {
            shortStr = str1;
            longStr = str2;
        }
        String temp = "";
        List<String> allSubString = getAllSubString(shortStr);
        for (String str : allSubString) {
            boolean flag = isDivides(str, shortStr, longStr);
            if (flag && temp.length() < str.length()) {
                temp = str;
            }
        }
        return temp;
    }

    /**
     * 判断字符串是不是被两个字符串可除
     *
     * @param str      str被除字符串
     * @param shortStr 除字符串
     * @param longStr  除字符串
     * @return
     */
    private boolean isDivides(String str, String shortStr, String longStr) {
        String sb1 = getString(str, shortStr);
        String sb2 = getString(str, longStr);
        return sb1.length() == 0 && sb2.length() == 0;

    }

    /**
     * 判断字符串是否能被整除
     *
     * @param str      字符串
     * @param shortStr 短字符串
     * @return 字符串
     */
    private String getString(String str, String shortStr) {
        StringBuilder sb = new StringBuilder();
        String[] strs = shortStr.split(str);
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 找出一个字符串的所有子串
     *
     * @param shortStr 主字符串
     * @return 字符串链表
     */
    private List<String> getAllSubString(String shortStr) {
        List<String> list = new ArrayList<>();
        if (shortStr == null) {
            return new ArrayList<>();
        }
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = i + 1; j <= shortStr.length(); j++) {
                String subStr = shortStr.substring(i, j);
                list.add(subStr);
            }
        }
        return list;
    }


    @Test
    public void splitString() {
        String str = "abcabc";
        String[] strs = str.split("abc");
        for (String s : strs) {
            System.out.println(s);
        }
        System.out.println();
    }
}
