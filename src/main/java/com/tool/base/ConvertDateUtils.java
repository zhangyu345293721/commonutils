package com.tool.base;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 * 若待转换值为null或者出现异常，则使用默认值
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ConvertDateUtils {

    /**
     * 字符串转换日期
     *
     * @param str          待转换的字符串
     * @param defaultValue 默认日期
     * @return 返回日期
     */
    public static Date strToDate(String str, Date defaultValue) {
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
    public static java.util.Date strToDate(String str, String format, Date defaultValue) {
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
    public static String dateToStr(Date date, String defaultValue) {
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
    public static String dateToStr(Date date, String format, String defaultValue) {
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
        if ((str != null) && (!(str.isEmpty()))) {
            defaultValue = str;
        }
        return defaultValue;
    }

    /**
     * util date 转换为 sqldate
     *
     * @param date date
     * @return 返回date类型
     */
    public static java.sql.Date dateToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * sql date 转换为 util date
     *
     * @param date date
     * @return 返回日期
     */
    public static java.util.Date sqlDateToDate(java.sql.Date date) {
        return new Date(date.getTime());
    }

    /**
     * date 转换为 timestamp
     *
     * @param date date
     * @return 返回Timestamp
     */
    public static Timestamp dateToSqlTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * timestamp 转换为date
     *
     * @param date 日期时间
     * @return 返回date
     */
    public static java.util.Date qlTimestampToDate(Timestamp date) {
        return new Date(date.getTime());
    }
    /**
     * 使用多个日期格式尝试解析字符串，成功则返回解析结果，否则返回默认值
     *
     * @param str           待解析的字符串
     * @param formats       日期格式数组，例如：{"yyyy-MM-dd", "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"}
     * @param defaultValue  默认日期
     * @return              解析得到的日期或默认值
     */
    public static Date strToDateTryFormats(String str, String[] formats, Date defaultValue) {
        if (str == null || formats == null) {
            return defaultValue;
        }
        for (String format : formats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                Date parsed = sdf.parse(str);
                if (parsed != null) {
                    return parsed;
                }
            } catch (Exception ignore) {
            }
        }
        return defaultValue;
    }
     /**
     * 日期转换为纪元秒（Unix Timestamp，单位秒）
     *
     * @param date          待转换日期
     * @param defaultValue  默认值
     * @return              纪元秒，或默认值
     */
    public static long dateToEpochSeconds(Date date, long defaultValue) {
        try {
            if (date == null) {
                return defaultValue;
            }
            return date.getTime() / 1000L;
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
