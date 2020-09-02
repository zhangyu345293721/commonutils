package com.tool.base.stream;

/**
 * int工具类
 * 不同的是parseInt()方法的返回值是int类型，而valueOf()返回值是Integer对象
 *
 * @author: zhangyu
 */
public class IntStreamUtils {
    private IntStreamUtils() {
    }

    /**
     * 2进制字符串
     *
     * @param i 十进制数
     * @return 字符串
     */
    public static String integer2BinaryStr(int i) {
        return Integer.toBinaryString(i);
    }

    /**
     * 8进制字符串
     *
     * @param i 八进制数
     * @return 字符串
     */
    public static String integer2OctalStr(int i) {
        return Integer.toOctalString(i);
    }

    /**
     * 16进制字符串
     *
     * @param i 16进制数
     * @return 字符串
     */
    public static String integer2HexStr(int i) {
        return Integer.toBinaryString(i);
    }

    /**
     * 整数
     *
     * @param i 几进制 2,8,16
     * @return 字符串
     */
    public static Integer string2Integer(int i, String str) {
        return Integer.valueOf(str, 2);
    }

    /**
     * 将字符链表变成数字数组
     *
     * @param str 输入字符串
     * @return int类型数组
     */
    public static int[] string2IntArrays(String str) {
        if (str == null) {
            return new int[0];
        }
        char[] chs = str.toCharArray();
        int[] arrays = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            arrays[i] = chs[i] - '0';
        }
        return arrays;
    }
}
