package com.tool.algo.arrangementselect;

import org.junit.jupiter.api.Test;

/**
 * 找出没有重复字符
 *
 * @author: zhangyu
 */
public class FirstUniqueCharacter387 {

    @Test
    public void firstAppearDemo() {
        // String s = "leetcode";
        String s = "aadadaae";
        int index = getFirstUniqueCharacterIndex(s);
        System.out.println(index);
    }

    private int getFirstUniqueCharacterIndex(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        // 中间出现
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String sub = s.substring(i + 1);
            String subStart = s.substring(0, i);
            if (sub.indexOf(ch) == -1 && subStart.indexOf(ch) == -1) {
                return i;
            }
        }
        // 最后一个是第一个出现
       /* char ch = s.charAt(s.length() - 1);
        String sub = s.substring(0, s.length() - 1);
        if (sub.indexOf(ch) == -1) {
            return s.length() - 1;
        }*/
        return -1;
    }


    private int getFirstUniqueCharacterIndex2(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        for (char ch : s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }


    @Test
    public void listTestDemo() {
        String ss = "abc";
        String s = ss.substring(4);
        System.out.println(s);
    }
}
