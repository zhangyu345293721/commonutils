package com.tool.base;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 数组工具类
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ArrayUtils {
    private ArrayUtils() {
    }

    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 布尔值
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组是否非空
     *
     * @param array 数组
     * @return 返回布尔值
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }


    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(boolean[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(byte[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(char[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(double[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(float[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(int[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(long[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组是否为不空
     *
     * @param array 数组
     * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(short[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断参数是否是一个数组
     *
     * @param obj 对象
     * @return 布尔值
     */
    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    /**
     * 将参数组装成数组
     *
     * @param obj 参数对象
     * @return 返回对象数组
     */
    public static <E> E[] asArray(E... obj) {
        return obj;
    }

    /**
     * 将参数集合转换为数组表示
     *
     * @param collection 集合参数
     * @return 布尔值
     */
    public static <E> E[] asArray(Collection<E> collection) {
        if (collection == null || collection.size() == 0) {
            return null;
        }
        int length = collection.size();
        E e = collection.iterator().next();
        @SuppressWarnings("unchecked")
        E[] array = (E[]) Array.newInstance(e.getClass(), length);
        return collection.toArray(array);
    }

    /**
     * 获取数组元素的实际数据类型
     *
     * @param array 数组
     * @return 布尔值
     */
    public static <E> Class<E> getElementType(E[] array) {
        Class<?> clas = array.getClass();
        Class<E> type = (Class<E>) clas.getComponentType();
        return type;
    }

    /**
     * 获取数组元素的实际数据类型
     *
     * @param array 数组
     * @return 布尔值
     */
    public static Class<?> getElementType(Object array) {
        if (!isArray(array)) {
            throw new IllegalArgumentException("argument must be an array");
        }
        return array.getClass().getComponentType();
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static <E> List<E> toList(E[] array) {
        return Arrays.asList(array);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Boolean> toList(boolean[] array) {
        int length = Array.getLength(array);
        return asList(new Boolean[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Byte> toList(byte[] array) {
        int length = Array.getLength(array);
        return asList(new Byte[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Character> toList(char[] array) {
        int length = Array.getLength(array);
        return asList(new Character[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Double> toList(double[] array) {
        int length = Array.getLength(array);
        return asList(new Double[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Float> toList(float[] array) {
        int length = Array.getLength(array);
        return asList(new Float[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Integer> toList(int[] array) {
        int length = Array.getLength(array);
        return asList(new Integer[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Long> toList(long[] array) {
        int length = Array.getLength(array);
        return asList(new Long[length], array, length);
    }

    /**
     * 数组转化为List
     *
     * @param array 数组
     * @return 布尔值
     */
    public static List<Short> toList(short[] array) {
        int length = Array.getLength(array);
        return asList(new Short[length], array, length);
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return
     */
    public static <E> boolean contains(E[] array, E arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 布尔值
     */
    public static boolean contains(byte[] array, byte arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 布尔值
     */
    public static boolean contains(char[] array, char arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 布尔值
     */
    public static boolean contains(short[] array, short arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 返回布尔值
     */
    public static boolean contains(int[] array, int arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 返回布尔值
     */
    public static boolean contains(long[] array, long arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 返回布尔值
     */
    public static boolean contains(float[] array, float arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 返回布尔值
     */
    public static boolean contains(double[] array, double arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 数组元素中是否包含参数对象
     *
     * @param array 数组
     * @param arg   元素参数
     * @return 返回布尔值
     */
    public static boolean contains(boolean[] array, boolean arg) {
        return indexOf(array, arg) >= 0;
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static <E> int indexOf(E[] array, E element) {
        int size = array.length;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(boolean[] array, boolean element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(byte[] array, byte element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(char[] array, char element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(double[] array, double element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(float[] array, float element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(int[] array, int element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(long[] array, long element) {
        return indexFrom(array, element);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    public static int indexOf(short[] array, short element) {
        return indexFrom(array, element);
    }

    /**
     * 列举
     *
     * @param array 数组
     * @return
     */
    public static <E> Enumeration<E> enumeration(E[] array) {
        return new ArrayEnumeration<E>(array);
    }

    /**
     * 元素所在数组的索引
     *
     * @param array   数组
     * @param element 元素
     * @return 若数组中不存在该元素, 则返回-1
     */
    private static int indexFrom(Object array, Object element) {
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object e = Array.get(array, i);
            if (element.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组转化为List
     *
     * @param target 目标数组
     * @param origin 源数组对象
     * @param length 数组长度
     * @return
     */
    private static <E> List<E> asList(E[] target, Object origin, int length) {
        // java.lang.ArrayStoreException
        // System.arraycopy(origin, 0, target, 0, length);
        for (int i = 0; i < length; i++) {
            target[i] = (E) Array.get(origin, i);
        }
        return Arrays.asList(target);
    }

    /**
     * 获取int的list中的最大值
     *
     * @param list
     * @return 返回int最大值
     */
    private static int getListMaxValue(List<Integer> list) {
        return Collections.max(list);
    }

    /**
     * 获取int的list中的最大值的下标
     *
     * @param list
     * @return 返回int最大值
     */
    private static int getListMaxValueIndex(List<Integer> list) {
        int max = list.get(0);
        //最大值下标
        int max_a = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(max_a)) {
                max = list.get(i);
                max_a = i;
            }
        }
        return max_a;
    }

    /**
     * 获取int的list中的最小值
     *
     * @param list
     * @return 返回int最小值
     */
    private static int getListMinValue(List<Integer> list) {
        return Collections.min(list);
    }

    /**
     * 获取int的list中的最大值的下标
     *
     * @param list list
     * @return 返回int最下值的下标
     */
    private static int getListMinValueIndex(List<Integer> list) {
        int min = list.get(0);
        //最大值下标
        int min_a = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(min_a)) {
                min_a = i;
            }
        }
        return min_a;
    }

    /**
     * 数组列举
     */
    private static class ArrayEnumeration<E> implements Enumeration<E> {

        private E[] es;
        private int index;
        private int length;

        private ArrayEnumeration(E[] es) {
            this.es = es;
            this.length = es.length;
        }

        @Override
        public boolean hasMoreElements() {
            return index < length;
        }

        @Override
        public E nextElement() {
            return es[index++];
        }
    }

    /**
     * 链表中随机选择一定数量的元素
     *
     * @param list 对象链表
     * @param num  选择链表长度
     * @return 字符串链表
     */
    public static <T> List<T> getRandomList(List<T> list, int num) {
        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>();
        }
        if (list.size() <= num) {
            return list;
        }
        Collections.shuffle(list);
        return list.subList(0, num);
    }
}
