package com.zhang.regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: utilsdemo
 * @description: 按照要求反转字符串
 * @author: zhangyu
 * @create: 2019-08-19 15:21
 */
public class Demo {

    @Test
    public void fun() {
        String s = "abcdefg";
        List<String> list = getStringList(s, 2);
        String s1 = getReverseString(list);
        System.out.println(s1);
    }

    private ArrayList<String> getStringList(String str, int n) {
        ArrayList<String> list = new ArrayList<String>();
        String regEx = "\\w{" + n + "}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        if (n * (list.size()) < str.length()) {
            list.add(str.substring(n * list.size()));
        }
        return list;
    }

    public String getReverseString(List<String> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                sb.append(new StringBuffer(list.get(i)).reverse().toString());
            } else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
