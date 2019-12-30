package com.tool.base;

import java.util.*;
import java.util.function.Function;

/**
 * 集合工具类
 *
 * @author :zhangyu
 */
public class CollectionUtil {

    /**
     * 集合是否为空
     *
     * @param collection 集合
     * @return 若集合为null, 或集合大小为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    /**
     * 集合是否不为空
     *
     * @param collection 集合
     * @return 若集合不为null, 而且集合大小不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 参数转换为List集合
     *
     * @param objs 参数对象
     * @return 返回泛型
     */
    public static <E> List<E> asList(E... objs) {
        return Arrays.asList(objs);
    }

    /**
     * 参数集合转换为List集合
     *
     * @param collection 集合参数
     * @return 返回list泛型
     */
    public static <E> List<E> asList(Collection<E> collection) {
        if (collection == null) {
            return null;
        }
        if (collection instanceof List) {
            return (List<E>) collection;
        }
        return new ArrayList<E>(collection);
    }

    /**
     * 参数转换为Set集合
     *
     * @param objs 参数对象
     * @return 返回set泛型
     */
    public static <E> Set<E> asSet(E... objs) {
        return new HashSet<E>(Arrays.asList(objs));
    }

    /**
     * 参数转换为Set集合
     *
     * @param collection 集合参数
     * @return 返回set泛型
     */
    public static <E> Set<E> asSet(Collection<E> collection) {
        if (collection == null) {
            return null;
        }
        if (collection instanceof Set) {
            return (Set<E>) collection;
        }
        return new HashSet<E>(collection);
    }

    /**
     * 将集合转换为数组
     *
     * @param collection 集合
     * @returns 返回数组
     */
    public static <E> E[] toArray(Collection<E> collection) {
        return ArrayUtils.asArray(collection);
    }

    /**
     * 创建ArrayList实例
     *
     * @return 返回list
     */
    public static <E> List<E> newList() {
        return new ArrayList<E>();
    }

    /**
     * 创建一个指定容量的ArrayList实例
     *
     * @param size 大小
     * @return 返回list
     */
    public static <E> List<E> newList(int size) {
        return new ArrayList<E>(size);
    }

    /**
     * 创建一个HashSet实例
     *
     * @return 返回set泛型
     */
    public static <E> Set<E> newSet() {
        return new HashSet<E>(16, .75f);
    }

    /**
     * 创建一个指定容量大小的HashSet实例
     *
     * @param initialCapacity 初始容量
     * @param loadFactor      加载因子
     * @return 返回set
     */
    public static <E> Set<E> newSet(int initialCapacity, double loadFactor) {
        return new HashSet<E>(initialCapacity, (float) loadFactor);
    }

    /**
     * 获取map的最小key的value
     *
     * @param map 传入map的值
     * @return String
     */
    public static String getMinKeysValue(Map<Integer, String> map) {
        int key = map.keySet().stream().min(Comparator.comparing(Function.identity())).get();
        return map.get(key);
    }
}