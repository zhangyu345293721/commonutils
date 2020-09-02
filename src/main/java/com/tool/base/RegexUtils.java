package com.tool.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类，验证数据是否符合规范
 *
 * @author zhangyu
 */
public class RegexUtils {

    private static final Pattern pattern2 = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    private static final Pattern pattern3 = Pattern.compile("[\u0391-\uFFE5]+$");
    private static final Pattern pattern4 = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
    private static final Pattern pattern5 = Pattern.compile("^[-\\+]?[\\d]+$");

    private RegexUtils() {
    }

    /**
     * 判断字符串是否符合正则表达式
     *
     * @param str   字符串
     * @param regex 正则表达式
     * @return 返回是否匹配的布尔值
     */
    public static boolean find(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        boolean b = m.find();
        return b;
    }

    /**
     * 判断输入的字符串是否符合Email格式.
     *
     * @param email 传入的字符串
     * @return 符合Email格式返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        return pattern2.matcher(email).matches();
    }

    /**
     * 判断输入的字符串是否为纯汉字
     *
     * @param value 传入的字符串
     * @return 返回布尔数
     */
    public static boolean isChinese(String value) {
        return pattern3.matcher(value).matches();
    }

    /**
     * 判断是否为浮点数，包括double和float
     *
     * @param value 传入的字符串
     * @return 返回布尔值
     */
    public static boolean isDouble(String value) {
        return pattern4.matcher(value).matches();
    }

    /**
     * 判断是否为整数
     *
     * @param value 传入的字符串
     * @return 返回布尔值
     */
    public static boolean isInteger(String value) {
        return pattern5.matcher(value).matches();
    }
}
