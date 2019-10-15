package com.tool.base;

import java.lang.reflect.Array;

/**
 * 八种基本类型之间的转换
 *
 * @author: zhangyu
 */

public class BaseTypeUtils {
    private static final String DEFAULT_STRING = "";
    private static final int DEFAULT_INT = 0;
    private static final long DEFAULT_LONG = 0L;
    private static final double DEFAULT_DOUBLE = 0.0D;
    private static final float DEFAULT_FLOAT = 0.0F;
    private static final boolean DEFAULT_BOOLEAN = Boolean.FALSE;
    private static final int integerCursor = 0;
    private static final int integerOffset = 8;
    private static final int decimalCursor = 8;
    private static final int decimalOffset = 4;
    private static final int numbersCursor = 0;
    private static final int numbersOffset = 12;
    private static final int indexNotFound = -1;
    private static final Class<?>[] types = {
            Byte.TYPE, Byte.class, Short.TYPE, Short.class, Integer.TYPE, Integer.class,
            Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class,
            Boolean.TYPE, Boolean.class, Character.TYPE, Character.class
    };

    /**
     * 将浮点数转成double类型数
     *
     * @param floatValue floatValue
     * @return 返回double类型
     */
    public static double toDouble(Float floatValue) {
        return toDouble(floatValue, DEFAULT_DOUBLE);
    }

    /**
     * 将任意类型转成int类型数据
     *
     * @param objectValue objectValue
     * @return 返回int类型
     */
    public static int toInt(Object objectValue) {
        return toInt(objectValue, DEFAULT_INT);
    }

    /**
     * @param stringValue  字符串类型数
     * @param defaultValue 默认值
     * @return 返回int类型数
     */
    public static int toInt(String stringValue, int defaultValue) {
        int intValue = defaultValue;
        if (null != stringValue && stringValue.length() > 0) {
            try {
                intValue = Integer.parseInt(stringValue);
            } catch (NumberFormatException numberFormatException) {
                System.err.println(numberFormatException.getMessage());
            }
        }
        return intValue;
    }

    /**
     * 将长整型数据转成int类型
     *
     * @param longValue 长整型数据
     * @return int类型数据
     */
    public static int toInt(Long longValue) {
        return toInt(longValue, DEFAULT_INT);
    }


    /**
     * 将布尔类型数转成int类型
     *
     * @param booleanValue 布尔默认值
     * @return 返回int类型数据
     */
    public static int toInt(Boolean booleanValue) {
        return toInt(booleanValue, DEFAULT_INT);
    }

    /**
     * 将double类型数转成int类型
     *
     * @param doubleValue double类型默认值
     * @return 返回int类型数据
     */
    public static int toInt(Double doubleValue) {
        return toInt(doubleValue, DEFAULT_INT);
    }

    /**
     * 将浮点类型数转成int类型数据
     *
     * @param floatValue 浮点型默认值
     * @return 返回int类型数据
     */
    public static int toInt(Float floatValue) {
        return toInt(floatValue, DEFAULT_INT);
    }

    /**
     * 将object类型数据转成长整型
     *
     * @param objectValue 任意类型默认值
     * @return 返回长整型数
     */
    public static long toLong(Object objectValue) {
        return toLong(objectValue, DEFAULT_LONG);
    }

    /**
     * 字符串类型转成长整型
     *
     * @param stringValue 字符串类型值
     * @return 长整型数
     */
    public static long toLong(String stringValue) {
        return toLong(stringValue, DEFAULT_LONG);
    }

    /**
     * 将长整型转成long
     *
     * @param intValue int类型值
     * @return 长整型数
     */
    public static long toLong(Integer intValue) {
        return toLong(intValue, DEFAULT_LONG);
    }

    /**
     * 将boolean类型转成long类型
     *
     * @param booleanValue 布尔类型
     * @return 返回长整型数
     */
    public static long toLong(Boolean booleanValue) {
        return toLong(booleanValue, DEFAULT_LONG);
    }

    /**
     * 将double类型数转成长整型
     *
     * @param doubleValue double类型数
     * @return 返回长整型数
     */
    public static long toLong(Double doubleValue) {
        return toLong(doubleValue, DEFAULT_LONG);
    }


    /**
     * 将浮点数转成long类型
     *
     * @param floatValue 浮点类型数
     * @return 长整型数
     */
    public static long toLong(Float floatValue) {
        return toLong(floatValue, DEFAULT_LONG);
    }


    /**
     * 将object类型转成布尔类型
     *
     * @param objectValue object类型值
     * @return 返回布尔类型
     */
    public static boolean toBoolean(Object objectValue) {
        return toBoolean(objectValue, DEFAULT_BOOLEAN);
    }

    /**
     * 将字符串类型数转成布尔类型数
     *
     * @param stringValue 字符串类型
     * @return 返回布尔类型
     */
    public static boolean toBoolean(String stringValue) {
        return toBoolean(stringValue, DEFAULT_BOOLEAN);
    }


    public static boolean toBoolean(Integer intValue) {
        return toBoolean(intValue, DEFAULT_BOOLEAN);
    }

    /**
     * @param longValue long类型值
     * @return 返回为默认值
     */
    public static boolean toBoolean(Long longValue) {
        return toBoolean(longValue, DEFAULT_BOOLEAN);
    }

    /**
     * @param objectValue 将任意类型转成float
     * @return 返回浮点数
     */
    public static float toFloat(Object objectValue) {
        return toFloat(objectValue, DEFAULT_FLOAT);
    }

    /**
     * 字符串类型转成浮点类型
     *
     * @param stringValue 字符串类型数据
     * @return 返回浮点数
     */
    public static float toFloat(String stringValue) {
        return toFloat(stringValue, DEFAULT_FLOAT);
    }

    /**
     * 将长整型转成double类型
     *
     * @param longValue 长整型值
     * @return 返回double类型
     */
    public static double toDouble(Long longValue) {
        return toDouble(longValue, DEFAULT_DOUBLE);
    }


    /**
     * 将int类型数转成浮点数类型
     *
     * @param intValue int类型数
     * @return 返回浮点数类型
     */
    public static float toFloat(Integer intValue) {
        return toFloat(intValue, DEFAULT_FLOAT);
    }

    /**
     * 将长整型类型数
     *
     * @param longValue 长整型数
     * @return 返回浮点数
     */
    public static float toFloat(Long longValue) {
        return toFloat(longValue, DEFAULT_FLOAT);
    }

    /**
     * 将double类型数转成浮点类型
     *
     * @param doubleValue double类型值
     * @return 返回浮点数
     */
    public static float toFloat(Double doubleValue) {
        return toFloat(doubleValue, DEFAULT_FLOAT);
    }

    /**
     * 将任意类型数转成double类型
     *
     * @param objectValue obejct类型值
     * @return
     */
    public static double toDouble(Object objectValue) {
        return toDouble(objectValue, DEFAULT_DOUBLE);
    }

    /**
     * 将字符串类型数转成double类型
     *
     * @param stringValue 字符串类型数
     * @return 返回double类型
     */
    public static double toDouble(String stringValue) {
        return toDouble(stringValue, DEFAULT_DOUBLE);
    }

    /**
     * 将int类型转成double类型
     *
     * @param intValue int类型值
     * @return 返回double类型
     */
    public static double toDouble(Integer intValue) {
        return toDouble(intValue, DEFAULT_DOUBLE);
    }

    /**
     * 判断是否是小数类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isDecimal(Class<?> type) {
        Class<?>[] decimal = subarray(types, decimalCursor, decimalCursor
                + decimalOffset);
        return ArrayUtils.contains(decimal, type);
    }

    /**
     * 判断是否是整数类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isInteger(Class<?> type) {
        Class<?>[] integer = subarray(types, integerCursor, integerCursor
                + integerOffset);
        return ArrayUtils.contains(integer, type);
    }

    /**
     * 判断是否是数值类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isNumber(Class<?> type) {
        Class<?>[] numbers = subarray(types, numbersCursor, numbersCursor
                + numbersOffset);
        return ArrayUtils.contains(numbers, type);
    }

    /**
     * Short转换
     *
     * @param value 字符串类型值
     * @return
     */
    static Short shortConvertor(String value) {
        return Short.valueOf(value);
    }

    /**
     * 判断是否是基本数据类型或装箱类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isCompatible(Class<?> type) {
        return ArrayUtils.contains(types, type);
    }

    /**
     * 是否是Byte/byte类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isByteType(Class<?> type) {
        return type == Byte.class || type == Byte.TYPE;
    }

    /**
     * 是否是Short/short类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isShortType(Class<?> type) {
        return type == Short.class || type == Short.TYPE;
    }

    /**
     * 是否是Integer/int类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isIntegerType(Class<?> type) {
        return type == Integer.class || type == Integer.TYPE;
    }

    /**
     * 是否是Long/long类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isLongType(Class<?> type) {
        return type == Long.class || type == Long.TYPE;
    }

    /**
     * 是否是Float/float类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isFloatType(Class<?> type) {
        return type == Float.class || type == Float.TYPE;
    }

    /**
     * 是否是Double/double类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isDoubleType(Class<?> type) {
        return type == Double.class || type == Double.TYPE;
    }

    /**
     * 是否是Boolean/boolean类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isBooleanType(Class<?> type) {
        return type == Boolean.class || type == Boolean.TYPE;
    }

    /**
     * 是否是Character/char类型
     *
     * @param type 被测试的类型
     * @return
     */
    public static boolean isCharacterType(Class<?> type) {
        return type == Character.class || type == Character.TYPE;
    }

    /**
     * 获取参数的基本数据类型
     *
     * @param type 类型
     * @return
     */
    public static Class<?> getPrimitive(Class<?> type) {
        if (type.isPrimitive()) {
            return type;
        }
        int index = ArrayUtils.indexOf(types, type);
        if (index != indexNotFound) {
            return types[index - 1];
        }
        throw new IllegalArgumentException(type.getSimpleName()
                + " is not primitive type");
    }

    /**
     * 获取参数的装箱类型
     *
     * @param type 类型
     * @return
     */
    public static Class<?> getBoxedPrimitive(Class<?> type) {
        int index = ArrayUtils.indexOf(types, type);
        if (index != indexNotFound) {
            type = types[index];
            if (type.isPrimitive()) {
                type = types[index + 1];
            }
            return type;
        }
        throw new IllegalArgumentException(type.getSimpleName()
                + " is not primitive type");
    }

    /**
     * 子数组
     *
     * @param array      源数组
     * @param beginIndex 开始索引
     * @param endIndex   结束索引
     * @return
     */
    private static <E> E[] subarray(E[] array, int beginIndex, int endIndex) {
        int length = endIndex - beginIndex;
        Class<?> type = ArrayUtils.getElementType(array);
        @SuppressWarnings("unchecked")
        E[] target = (E[]) Array.newInstance(type, length);
        System.arraycopy(array, beginIndex, target, 0, length);
        return target;
    }


    public static double toDouble(Long longValue, double defaultValue) {
        double doubleValue = defaultValue;
        if (null != longValue) {
            doubleValue = longValue.doubleValue();
        }
        return doubleValue;
    }

    public static double toDouble(Float floatValue, double defaultValue) {
        double doubleValue = defaultValue;
        if (null != floatValue) {
            doubleValue = floatValue.doubleValue();
        }
        return doubleValue;
    }

    public static boolean toBoolean(Integer intValue, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (null != intValue) {
            booleanValue = intValue == 1;
        }
        return booleanValue;
    }

    public static int toInt(Long longValue, int defaultValue) {
        int intValue = defaultValue;
        if (null != longValue) {
            intValue = longValue.intValue();
        }
        return intValue;
    }

    public static boolean toBoolean(String stringValue, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (null != stringValue && stringValue.length() > 0) {
            booleanValue = Boolean.valueOf(stringValue);
        }
        return booleanValue;
    }

    public static String toString(Object obj, String defaultValue) {
        return obj != null ? obj.toString() : defaultValue;
    }

    public static long toLong(Double doubleValue, long defaultValue) {
        long longValue = defaultValue;
        if (null != doubleValue) {
            longValue = doubleValue.longValue();
        }
        return longValue;
    }

    public static boolean toBoolean(Long longValue, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (null != longValue) {
            booleanValue = longValue.longValue() == 1L;
        }
        return booleanValue;
    }

    public static String toString(Object obj) {
        return toString(obj, DEFAULT_STRING);
    }

    public static long toLong(Float floatValue, long defaultValue) {
        long longValue = defaultValue;
        if (null != floatValue) {
            longValue = floatValue.longValue();
        }
        return longValue;
    }

    public static String toString(Integer intValue, String defaultValue) {
        return intValue != null ? String.valueOf(intValue) : defaultValue;
    }

    public static String toString(Integer intValue) {
        return toString(intValue, DEFAULT_STRING);
    }

    public static String toString(Long longValue, String defaultValue) {
        return longValue != null ? String.valueOf(longValue) : defaultValue;
    }

    public static String toString(Long longValue) {
        return toString(longValue, DEFAULT_STRING);
    }

    public static String toString(Boolean booleanValue, String defaultValue) {
        return booleanValue != null ? String.valueOf(booleanValue) : defaultValue;
    }

    public static String toString(Boolean booleanValue) {
        return toString(booleanValue, DEFAULT_STRING);
    }

    public static String toString(Double doubleValue, String defaultValue) {
        return null != doubleValue ? String.valueOf(doubleValue) : defaultValue;
    }

    public static String toString(Double doubleValue) {
        return toString(doubleValue, DEFAULT_STRING);
    }

    public static String toString(Float floatValue, String defaultValue) {
        return null != floatValue ? String.valueOf(floatValue) : defaultValue;
    }

    public static String toString(Float floatValue) {
        return toString(floatValue, DEFAULT_STRING);
    }


    public static int toInt(Object objectValue, int defaultValue) {
        int intValue = defaultValue;
        if (null != objectValue) {
            try {
                intValue = Integer.parseInt(toString(objectValue, toString(defaultValue)));
            } catch (NumberFormatException numberFormatException) {
                System.err.println(numberFormatException.getMessage());
            }
        }
        return intValue;
    }

    public static int toInt(Boolean booleanValue, int defaultValue) {
        int intValue = defaultValue;
        if (null != booleanValue) {
            intValue = booleanValue ? 1 : 0;
        }
        return intValue;
    }

    public static float toFloat(Integer intValue, float defaultValue) {
        float floatValue = defaultValue;
        if (null != intValue) {
            floatValue = intValue.floatValue();
        }
        return floatValue;
    }

    public static double toDouble(Integer intValue, double defaultValue) {
        double doubleValue = defaultValue;
        if (null != intValue) {
            doubleValue = intValue.doubleValue();
        }
        return doubleValue;
    }

    public static int toInt(Double doubleValue, int defaultValue) {
        int intValue = defaultValue;
        if (null != doubleValue) {
            intValue = doubleValue.intValue();
        }
        return intValue;
    }

    public static double toDouble(String stringValue, double defaultValue) {
        double doubleValue = defaultValue;
        if (null != stringValue && stringValue.length() > 0) {
            doubleValue = Double.parseDouble(stringValue);
        }
        return doubleValue;
    }

    public static int toInt(Float floatValue, int defaultValue) {
        int intValue = defaultValue;
        if (null != floatValue) {
            intValue = floatValue.intValue();
        }
        return intValue;
    }

    public static float toFloat(Long longValue, float defaultValue) {
        float floatValue = defaultValue;
        if (null != longValue) {
            floatValue = longValue.floatValue();
        }
        return floatValue;
    }


    public static float toFloat(Double doubleValue, float defaultValue) {
        float floatValue = defaultValue;
        if (null != doubleValue) {
            floatValue = doubleValue.floatValue();
        }
        return floatValue;
    }

    public static long toLong(Object objectValue, long defaultValue) {
        long longValue = defaultValue;
        if (null != objectValue) {
            try {
                longValue = Long.parseLong(toString(objectValue, toString(defaultValue)));
            } catch (NumberFormatException numberFormatException) {
                System.err.println(numberFormatException.getMessage());
            }
        }
        return longValue;
    }

    public static double toDouble(Object objectValue, double defaultValue) {
        double doubleValue = defaultValue;
        if (null != objectValue) {
            doubleValue = Double.parseDouble(toString(objectValue, toString(defaultValue)));
        }
        return doubleValue;
    }

    public static float toFloat(String stringValue, float defaultValue) {
        float floatValue = defaultValue;
        if (null != stringValue && stringValue.length() > 0) {
            try {
                floatValue = Float.valueOf(stringValue);
            } catch (NumberFormatException numberFormatException) {
                System.err.println(numberFormatException.getMessage());
            }
        }
        return floatValue;
    }

    public static long toLong(String stringValue, long defaultValue) {
        long longValue = defaultValue;
        if (null != stringValue && stringValue.length() > 0) {
            longValue = Long.parseLong(stringValue);
        }
        return longValue;
    }

    public static long toLong(Boolean booleanValue, long defaultValue) {
        long longValue = defaultValue;
        if (null != booleanValue) {
            longValue = booleanValue ? 1L : 0L;
        }
        return longValue;
    }

    public static float toFloat(Object objectValue, float defaultValue) {
        float floatValue = defaultValue;
        if (null != objectValue) {
            try {
                floatValue = Float.valueOf(toString(objectValue, toString(defaultValue)));
            } catch (NumberFormatException numberFormatException) {
                System.err.println(numberFormatException);
            }
        }
        return floatValue;
    }

    public static long toLong(Integer intValue, long defaultValue) {
        long longValue = defaultValue;
        if (null != intValue) {
            longValue = intValue.longValue();
        }
        return longValue;
    }

    public static boolean toBoolean(Object objectValue, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (null != objectValue) {
            booleanValue = Boolean.valueOf(toString(objectValue, toString(defaultValue)));
        }
        return booleanValue;
    }
}
