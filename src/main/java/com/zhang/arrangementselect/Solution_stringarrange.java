package com.zhang.arrangementselect;

/**
 * @program: utilsdemo
 * @description:
 * @author: zhangyu
 * @create: 2019-09-25 23:17
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。
 *
 * @author pomay
 */
public class Solution_stringarrange {
    public static ArrayList<String> Permutation(String str) {
        if (str == null)
            return null;
        ArrayList<String> list = new ArrayList<String>();
        char[] pStr = str.toCharArray();
        Permutation(pStr, 0, list);
        Collections.sort(list);
        return list;
    }

    static void Permutation(char[] str, int i, ArrayList<String> list) {
        // 如果为空
        if (str == null)
            return;
        // 如果i指向了最后一个字符
        if (i == str.length - 1) {
            if (list.contains(String.valueOf(str)))
                return;
            list.add(String.valueOf(str));
        } else {
            // i指向当前我们做排列操作的字符串的第一个字符
            for (int j = i; j < str.length; j++) {
                // 把做排列操作的字符串的第一个字符和后面的所有字符交换
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                // 交换后对i后面的字符串递归做排列操作
                Permutation(str, i + 1, list);
                // 每一轮结束后换回来进行下一轮排列操作
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        Solution_stringarrange changestring = new Solution_stringarrange();
        ArrayList<String> list = changestring.Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
