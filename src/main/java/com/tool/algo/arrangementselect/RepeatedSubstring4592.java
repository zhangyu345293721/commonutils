package com.tool.algo.arrangementselect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 重复子字符串（换一种思路）
 *
 * @author: zhangyu
 */
public class RepeatedSubstring4592 {


    @Test
    public void repeatedSubstring() {
        String s = "bb";
        boolean flag = repeatedSubstringPattern(s);
        System.out.println("flag = " + flag);
    }

    public boolean repeatedSubstringPattern(String s) {
        List<String> subStrList = getSubStrList(s);
        boolean flag = false;
        for (String str : subStrList) {
            if (isDivide(str, s)) {
                flag = true;
            }
        }
        return flag;
    }

    private boolean isDivide(String str, String s) {
        String[] strings = s.split(str);
        String result = Arrays.asList(strings).stream().collect(Collectors.joining(""));
        return result.isEmpty();
    }

    private List<String> getSubStrList(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            list.add(s.substring(0, i));
        }
        return list;
    }
}
