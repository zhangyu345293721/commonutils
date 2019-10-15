package com.tool.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 转换工具类<br>
 * 若待转换值为null或者出现异常，则使用默认值
 */
public class ConvertUtils {

    /**
     * 字符串转换日期
     *
     * @param str          待转换的字符串
     * @param defaultValue 默认日期
     * @return 返回日期
     */
    public static java.util.Date strToDate(String str, java.util.Date defaultValue) {
        return strToDate(str, "yyyy-MM-dd HH:mm:ss", defaultValue);
    }

    /**
     * 字符串转换为指定格式的日期
     *
     * @param str          待转换的字符串
     * @param format       日期格式
     * @param defaultValue 默认日期
     * @return 返回日期
     */
    public static java.util.Date strToDate(String str, String format, java.util.Date defaultValue) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        try {
            defaultValue = fmt.parse(str);
        } catch (Exception localException) {
        }
        return defaultValue;
    }

    /**
     * 日期转换为字符串
     *
     * @param date         待转换的日期
     * @param defaultValue 默认字符串
     * @return 返回字符串
     */
    public static String dateToStr(java.util.Date date, String defaultValue) {
        return dateToStr(date, "yyyy-MM-dd HH:mm:ss", defaultValue);
    }

    /**
     * 日期转换为指定格式的字符串
     *
     * @param date         待转换的日期
     * @param format       指定格式
     * @param defaultValue 默认值
     * @return 返回字符串
     */
    public static String dateToStr(java.util.Date date, String format, String defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            defaultValue = sdf.format(date);
        } catch (Exception localException) {
        }
        return defaultValue;
    }

    /**
     * 如果字符串为空则使用默认字符串
     *
     * @param str          字符串
     * @param defaultValue 默认值
     * @return 返回字符串
     */
    public static String strToStr(String str, String defaultValue) {
        if ((str != null) && (!(str.isEmpty())))
            defaultValue = str;
        return defaultValue;
    }

    /**
     * util date 转换为 sqldate
     *
     * @param date date
     * @return 返回date类型
     */
    public static java.sql.Date dateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * sql date 转换为 util date
     *
     * @param date
     * @return
     */
    public static java.util.Date sqlDateToDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

    /**
     * date 转换为 timestamp
     *
     * @param date date
     * @return 返回Timestamp
     */
    public static Timestamp dateToSqlTimestamp(java.util.Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * timestamp 转换为date
     *
     * @param date 日期时间
     * @return 返回date
     */
    public static java.util.Date qlTimestampToDate(Timestamp date) {
        return new java.util.Date(date.getTime());
    }
}
