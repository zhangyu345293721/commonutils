package com.tool.base;

import java.util.Random;
import java.math.BigDecimal;

/**
 * 随机方法工具类
 */
public class RandomUtils {

    private static final int DISPLAYABLE_MIN_INDEX = 33;
    private static final int DISPLAYABLE_MAX_INDEX = 127 - 1;
    private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_CHAR = "0123456789";
    private static final ThreadLocal<Random> local = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random();
        }
    };


    /**
     * 获取定长的随机数，包含大小写、数字
     *
     * @param length 随机数长度
     * @return 返回字符串
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 获取定长的随机数，包含大小写字母
     *
     * @param length 随机数长度
     * @return 返回字符串
     */
    public static String generateMixString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 获取定长的随机数，只包含小写字母
     *
     * @param length 随机数长度
     * @return 返回字符串
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * 获取定长的随机数，只包含大写字母
     *
     * @param length 随机数长度
     * @return 返回字符串
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    /**
     * 获取定长的随机数，只包含数字
     *
     * @param length 随机数长度
     * @return 返回字符串
     */
    public static String generateNumberString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 获取Random实例
     *
     * @return 返回随机值
     */
    public static Random getRandom() {
        return local.get();
    }

    /**
     * 产生[0, x]区间的随机数
     *
     * @param x > 0
     * @return
     */
    public static int intSeed(int x) {
        return intSeed(0, x);
    }

    /**
     * 产生[x, y]区间的随机数
     *
     * @param x >= 0
     * @param y > x
     * @return 返回int数
     */
    public static int intSeed(int x, int y) {
        if (x < 0) { // ensure x >= 0
            throw new IllegalArgumentException(
                    "x must be greater than or equal 0");
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException("y must be greater than x");
        }
        return x + getRandom().nextInt(y - x + 1);
    }

    /**
     * 产生[0, x]区间的随机数
     *
     * @param x> 0
     * @return 返回长整型
     */
    public static long longSeed(long x) {
        return longSeed(0, x);
    }

    /**
     * 产生[x, y]区间的随机数
     *
     * @param x >= 0
     * @param y > x
     * @return 返回长整型
     */
    public static long longSeed(long x, long y) {
        if (x < 0) { // ensure x >= 0
            throw new IllegalArgumentException(
                    "x must be greater than or equal 0");
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException("y must be greater than x");
        }
        return Math.abs(getRandom().nextLong() % (y - x + 1)) + x;
    }

    /**
     * 产生[0, x]区间的随机小数
     *
     * @param x > 0
     * @return 返回浮点数
     */
    public static float floatSeed(float x) {
        return (float) doubleSeed(0., x);
    }

    /**
     * 产生[x, y]区间的随机小数
     *
     * @param x >= 0
     * @param y > x
     * @return 返回浮点数
     */
    public static float floatSeed(float x, float y) {
        return (float) doubleSeed(x, y);
    }

    /**
     * 产生[0, x]区间的随机小数
     *
     * @param x > 0
     * @return 返回double类型
     */
    public static double doubleSeed(double x) {
        return doubleSeed(0., x);
    }

    /**
     * 产生[x, y]区间的随机小数
     *
     * @param x >= 0
     * @param y > x
     * @return 返回double类型
     */
    public static double doubleSeed(double x, double y) {
        if (x < 0) { // ensure x >= 0
            throw new IllegalArgumentException(
                    "x must be greater than or equal 0");
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException("y must be greater than x");
        }
        BigDecimal dx = new BigDecimal(String.valueOf(x));
        BigDecimal dy = new BigDecimal(String.valueOf(y));
        double diff = dy.subtract(dx).doubleValue();
        dx = dx.add(new BigDecimal(String.valueOf(getRandom().nextDouble()
                * diff)));
        return dx.doubleValue();
    }

    /**
     * 随机产生true或false
     *
     * @return 返回布尔类型
     */
    public static boolean boolSeed() {
        return intSeed(0, 1) == 0 ? false : true;
    }

    /**
     * 随机产生有效的可显示的字符
     *
     * @param x >= 33
     * @param y > x & <= 126
     * @return 返回char
     */
    public static char charSeed(char x, char y) {
        if (x < DISPLAYABLE_MIN_INDEX) { // ensure x >= 33 ('!')
            throw new IllegalArgumentException(
                    "x must be greater than or equal '!'");
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException("y must be greater than x");
        }
        if (y > DISPLAYABLE_MAX_INDEX) { // ensure y <= 126 ('~')
            throw new IllegalArgumentException(
                    "y must be less than or equal '~'");
        }
        return (char) (getRandom().nextInt(y - x + 1) + x);
    }
}