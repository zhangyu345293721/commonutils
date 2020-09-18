package com.tool.base;

/**
 * 判断对象是否为空
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ObjectUtils {

    private ObjectUtils() {
    }

    /**
     * 判断对象数组是否为空
     *
     * @param t 对象数组
     * @return 布尔值
     */
    public static boolean isEmpty(Object[] t) {
        return !notEmpty(t);
    }

    /**
     * 判断对象是否为空
     *
     * @param t 对象
     * @return 布尔值
     */
    public static boolean isEmpty(Object t) {
        return !notEmpty(t);
    }

    /**
     * 判断对象数组是否为空
     *
     * @param t 对象数组
     * @return 布尔值
     */
    public static boolean notEmpty(Object[] t) {
        return t != null && t.length > 0;
    }

    /**
     * 判断对象是否为空
     *
     * @param o 对象
     * @return 布尔值
     */
    public static boolean notEmpty(Object o) {
        return o != null && !"".equals(o) && !"null".equals(o);
    }

}
