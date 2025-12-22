package com.tool.base;

import java.util.Random;
import java.math.BigDecimal;

/**
 * 随机方法工具类
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RandomUtils {

    private RandomUtils() {
    }

    static Random random = new Random();
    static String GREATER_THAN = "x must be greater than or equal 0";
    static String Y_GREATER_THAN_X = "y must be greater than x";
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
        StringBuilder sb = new StringBuilder();
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
        StringBuilder sb = new StringBuilder();
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
        StringBuilder sb = new StringBuilder();
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
                    Y_GREATER_THAN_X);
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException("");
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
                    GREATER_THAN);
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException(Y_GREATER_THAN_X);
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
                    "GREATER_THAN");
        }
        if (x >= y) { // ensure y > x
            throw new IllegalArgumentException("Y_GREATER_THAN_X");
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
            throw new IllegalArgumentException("Y_GREATER_THAN_X");
        }
        if (y > DISPLAYABLE_MAX_INDEX) { // ensure y <= 126 ('~')
            throw new IllegalArgumentException(
                    "y must be less than or equal '~'");
        }
        return (char) (getRandom().nextInt(y - x + 1) + x);
    }
     /**
     * 1) 按给定字符集生成定长随机字符串
     *
     * @param length 生成长度（>=0）
     * @param charset 字符集，非空且长度>0
     * @return 随机字符串
     */
    public static String generateString(int length, String charset) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be >= 0");
        }
        if (charset == null || charset.isEmpty()) {
            throw new IllegalArgumentException("charset must not be empty");
        }
        StringBuilder sb = new StringBuilder(length);
        Random r = getRandom();
        for (int i = 0; i < length; i++) {
            sb.append(charset.charAt(r.nextInt(charset.length())));
        }
        return sb.toString();
    }
     /**
     * 2) 带概率的布尔随机：返回true的概率为p（0<=p<=1）
     *
     * @param p 返回true的概率
     * @return 随机布尔
     */
    public static boolean boolSeed(double p) {
        if (p < 0.0 || p > 1.0) {
            throw new IllegalArgumentException("p must be in [0,1]");
        }
        return getRandom().nextDouble() < p;
    }
    /**
     * 3) 生成区间内不重复的n个随机整数（[x, y] 且 x>=0, y>x）
     *
     * @param n 需要的数量（0 <= n <= y-x+1）
     * @param x 区间下界（包含，且 >=0）
     * @param y 区间上界（包含，且 > x）
     * @return 不重复的随机整数数组（长度为n）
     */
    public static int[] distinctIntSeeds(int n, int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException(GREATER_THAN);
        }
        if (x >= y) {
            throw new IllegalArgumentException(Y_GREATER_THAN_X);
        }
        int size = y - x + 1;
        if (n < 0 || n > size) {
            throw new IllegalArgumentException("n must be in [0, y-x+1]");
        }
        // 当n接近size时，使用池抽取更高效；当n远小于size时，用set采样
        if (n > size / 2) {
            // 生成池然后部分洗牌
            int[] pool = new int[size];
            for (int i = 0; i < size; i++) {
                pool[i] = x + i;
            }
            Random r = getRandom();
            for (int i = 0; i < n; i++) {
                int j = i + r.nextInt(size - i);
                int tmp = pool[i];
                pool[i] = pool[j];
                pool[j] = tmp;
            }
            int[] out = new int[n];
            System.arraycopy(pool, 0, out, 0, n);
            return out;
        } else {
            HashSet<Integer> set = new HashSet<>(n * 2 + 1);
            Random r = getRandom();
            while (set.size() < n) {
                set.add(x + r.nextInt(size));
            }
            int[] out = new int[n];
            int idx = 0;
            for (Integer v : set) {
                out[idx++] = v;
            }
            return out;
        }
    }
    /**
     * 4) 正态分布随机数，指定均值与标准差
     *
     * @param mean 均值
     * @param stdDev 标准差（>0）
     * @return 服从N(mean, stdDev^2)的随机数
     */
    public static double gaussian(double mean, double stdDev) {
        if (stdDev <= 0) {
            throw new IllegalArgumentException("stdDev must be > 0");
        }
        return mean + stdDev * getRandom().nextGaussian();
    }
}