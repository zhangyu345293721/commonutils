package com.base;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Map;

/**
 * 判断对象、字符串、集合是否为空、不为空
 */
public final class ClassHelper {

    /**
     * 判断数组是否为空
     *
     * @param array array
     * @return boolean类型
     */
    private static <T> boolean isEmptyArray(T[] array) {
        if (array == null || array.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 检验对象是否为空,String 中只有空格在对象中也算空.
     *
     * @param object object
     * @return 为空返回true, 否则false.
     */
    public static boolean isEmpty(Object object) {
        if (null == object)
            return true;
        else if (object instanceof String)
            return "".equals(object.toString().trim());
        else if (object instanceof Iterable)
            return !((Iterable) object).iterator().hasNext();
        else if (object.getClass().isArray())
            return Array.getLength(object) == 0;
        else if (object instanceof Map)
            return ((Map) object).size() == 0;
        else if (Number.class.isAssignableFrom(object.getClass()))
            return false;
        else if (Date.class.isAssignableFrom(object.getClass()))
            return false;
        else
            return false;
    }
}
