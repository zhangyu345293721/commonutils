package com.tool.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类，对字符串进行常规的处理
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class StringUtils {

    private StringUtils() {
    }

    private static final int INDEX_NOT_FOUND = -1;
    private static final String NULL = "null";
    private static final String PLACEHOLDER = "\\?";

    /**
     * 将半角的符号转换成全角符号.(即英文字符转中文字符)
     *
     * @param str 要转换的字符
     * @return 返回字符串
     */
    public static String changeToFull(String str) {
        String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
        String[] decode = {"１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
                "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
                "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
                "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
                "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
                "'", "\"", "，", "〈", "。", "〉", "／", "？"};
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = source.indexOf(str.charAt(i));
            if (pos != -1) {
                result += decode[pos];
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * 将字符转换为编码为Unicode，格式 为'\u0020'<br>
     * unicodeEscaped(' ') = "\u0020"<br>
     * unicodeEscaped('A') = "\u0041"
     *
     * @param ch 待转换的char 字符
     * @return 返回字符串
     */
    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }

    /**
     * 进行toString操作，若为空，返回默认值
     *
     * @param object  要进行toString操作的对象
     * @param nullStr 返回的默认值
     * @return 返回字符串
     */
    public static String toString(Object object, String nullStr) {
        return object == null ? nullStr : object.toString();
    }

    /**
     * 将字符串重复N次，null、""不在循环次数里面 <br>
     * 当value == null || value == "" return value;<br>
     * 当count <= 1 返回  value
     *
     * @param value 需要循环的字符串
     * @param count 循环的次数
     * @return 返回字符串
     */
    public static String repeatString(String value, int count) {
        if (value == null || "".equals(value) || count <= 1) {
            return value;
        }

        int length = value.length();
        if (length == 1) {          //长度为1，存在字符
            return repeatChar(value.charAt(0), count);
        }

        int outputLength = length * count;
        switch (length) {
            case 1:
                return repeatChar(value.charAt(0), count);
            case 2:
                char ch0 = value.charAt(0);
                char ch1 = value.charAt(1);
                char[] output2 = new char[outputLength];
                for (int i = count * 2 - 2; i >= 0; i--, i--) {
                    output2[i] = ch0;
                    output2[i + 1] = ch1;
                }
                return new String(output2);
            default:
                StringBuilder buf = new StringBuilder(outputLength);
                for (int i = 0; i < count; i++) {
                    buf.append(value);
                }
                return buf.toString();
        }
    }

    /**
     * 将某个字符重复N次
     *
     * @param ch    需要循环的字符
     * @param count 循环的次数
     * @return 返回布尔值
     */
    public static String repeatChar(char ch, int count) {
        char[] buf = new char[count];
        for (int i = count - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }

    /**
     * 判断字符串是否全部都为小写
     *
     * @param value 待判断的字符串
     * @return 返回布尔值
     */
    public static boolean isAllLowerCase(String value) {
        if (value == null || "".equals(value.trim())) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (Character.isLowerCase(value.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否全部大写
     *
     * @param value 待判断的字符串
     * @return 返回布尔值
     */
    public static boolean isAllUpperCase(String value) {
        if (value == null || "".equals(value.trim())) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            if (Character.isUpperCase(value.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 反转字符串
     *
     * @param value 待反转的字符串
     * @return 返回字符串
     */
    public static String reverse(String value) {
        if (value == null) {
            return null;
        }
        return new StringBuffer(value).reverse().toString();
    }

    /**
     * 截取字符串，支持中英文混乱，其中中文当做两位处理
     *
     * @param resourceString resourceString
     * @param length         length
     * @return 返回字符串
     */
    public static String subString(String resourceString, int length) {
        String resultString = "";
        if (resourceString == null || "".equals(resourceString) || length < 1) {
            return resourceString;
        }
        if (resourceString.length() < length) {
            return resourceString;
        }
        char[] chr = resourceString.toCharArray();
        int strNum = 0;
        int strGBKNum = 0;
        boolean isHaveDot = false;
        for (int i = 0; i < resourceString.length(); i++) {
            if (chr[i] >= 0xa1) {// 0xa1汉字最小位开始
                strNum = strNum + 2;
                strGBKNum++;
            } else {
                strNum++;
            }
            if (strNum == length || strNum == length + 1) {
                if (i + 1 < resourceString.length()) {
                    isHaveDot = true;
                }
                break;
            }
        }
        resultString = resourceString.substring(0, strNum - strGBKNum);
        if (isHaveDot) {
            resultString = resultString + "...";
        }
        return resultString;
    }

    /**
     * *
     *
     * @param htmlString htmlString
     * @param length     字符串长度
     * @return 返回字符串
     */
    public static String subHTMLString(String htmlString, int length) {
        return subString(delHTMLTag(htmlString), length);
    }

    /**
     * 过滤html标签，包括script、style、html、空格、回车标签
     *
     * @param htmlStr htmlStr
     * @return 返回字符串类型
     */
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签  

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签  

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签  

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        return htmlStr.trim(); // 返回文本字符串
    }

    /**
     * 判断字符串是否为空
     *
     * @param string string
     * @return boolean
     */
    public static boolean isEmptyString(String string) {
        if (string == null || string.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否不为空
     *
     * @param string string
     * @return boolean
     */
    public static boolean isNotEmptyString(String string) {
        if (string != null && string.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断集合是否为空
     *
     * @param collection collection
     * @return boolean
     */
    public static boolean isEmptyCollection(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断集合是否不为空
     *
     * @param collection collection
     * @return boolean
     */
    public static boolean isNotEmptyCollection(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断map集合是否不为空
     *
     * @param map map
     * @return boolean
     */
    public static boolean isNotEmptyMap(Map map) {
        if (map != null && !map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断map集合是否为空
     *
     * @param map map
     * @return boolean
     */
    public static boolean isEmptyMap(Map map) {
        if (map == null || map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param source 字符串
     * @return 若为null或长度为0, 则返回true, 否则返回false
     */
    public static boolean isEmpty(String source) {
        return source == null || source.length() == 0;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param source 字符串
     * @return 若不为null而且长度不为0, 则返回true, 否则返回false
     */
    public static boolean isNotEmpty(String source) {
        return !isEmpty(source);
    }

    /**
     * 分割字符串得到子串
     *
     * @param source     源字符串
     * @param beginIndex 开始索引, 允许负数值, 表示从后往前
     * @return
     */
    public static String subStringFunction(String source, int beginIndex) {
        return subStringFunction(source, beginIndex, source.length());
    }

    /**
     * 分割字符串得到子串
     *
     * @param source     源字符串
     * @param beginIndex 开始索引, 允许负数值, 表示从后往前
     * @param endIndex   结束索引, 允许负数值, 表示从后往前
     * @return 返回字符串
     */
    public static String subStringFunction(String source, int beginIndex, int endIndex) {
        int length = source.length();
        if (beginIndex < 0) {
            beginIndex += length;
        }
        if (endIndex < 0) {
            endIndex += length;
        }
        if (beginIndex > endIndex) {
            throw new StringIndexOutOfBoundsException(
                    "String index out of range: " + (endIndex - beginIndex));
        }
        return source.substring(beginIndex, endIndex);
    }

    /**
     * 获取子串在源串中第一次出现的位置结束, 索引从0开始的串
     *
     * @param source    源串
     * @param substring 子串
     * @return 若源串中不含有子串, 则返回一个空串
     */
    public static String beforeString(String source, String substring) {
        int index = source.indexOf(substring);
        if (index != INDEX_NOT_FOUND) {
            return source.substring(0, index);
        }
        return "";
    }

    /**
     * 获取子串在源串中最后一次出现的位置结束, 索引从0开始的串
     *
     * @param source    源串
     * @param substring 子串
     * @return 若源串中不含有子串, 则返回一个空串
     */
    public static String beforeLastString(String source, String substring) {
        int index = source.lastIndexOf(substring);
        if (index != INDEX_NOT_FOUND) {
            return source.substring(0, index);
        }
        return "";
    }

    /**
     * 获取子串在源串中第一次出现的位置开始, 至源串末尾的串
     *
     * @param source    源串
     * @param substring 子串
     * @return 若源串中不含有子串, 则返回一个空串
     */
    public static String afterString(String source, String substring) {
        int index = source.indexOf(substring);
        if (index != INDEX_NOT_FOUND) {
            return source.substring(index + substring.length());
        }
        return "";
    }

    /**
     * 获取子串在源串中最后一次出现的位置开始, 至源串末尾的串
     *
     * @param source    源串
     * @param substring 子串
     * @return 若源串中不含有子串, 则返回一个空串
     */
    public static String afterLastString(String source, String substring) {
        int index = source.lastIndexOf(substring);
        if (index != INDEX_NOT_FOUND) {
            return source.substring(index + substring.length());
        }
        return "";
    }

    /**
     * 获取源串中, 两个子串之间的串
     *
     * @param source 源串
     * @param begin  子串
     * @param end    子串
     * @return 若源串中不含有其中任一子串, 则返回一个空串
     */
    public static String betweenString(String source, String begin, String end) {
        int endIndex = source.indexOf(end);
        int beginIndex = source.indexOf(begin);
        if (beginIndex != INDEX_NOT_FOUND && endIndex != INDEX_NOT_FOUND) {
            return source.substring(beginIndex + begin.length(), endIndex);
        }
        return "";
    }

    /**
     * 首字母大写
     *
     * @param str 字符串
     * @return 返回字符串
     */
    public static String toCapitalize(String str) {
        byte[] bytes = str.getBytes();
        byte e = bytes[0];
        if (e >= 'a' && e <= 'z') {
            bytes[0] -= 32;
        }
        return new String(bytes);
    }

    /**
     * 首字母小写
     *
     * @param str 字符串
     * @return 返回字符串
     */
    public static String toUncapitalize(String str) {
        byte[] bytes = str.getBytes();
        byte e = bytes[0];
        if (e >= 'A' && e <= 'Z') {
            bytes[0] += 32;
        }
        return new String(bytes);
    }

    /**
     * 以参数替换占位符[?]的形式格式化字符串
     *
     * @param origin 字符串
     * @param args   参数
     * @return 返回字符串
     */
    public static String format(String origin, Object... args) {
        for (Object arg : args) {
            origin = origin.replaceFirst(PLACEHOLDER,
                    arg == null ? NULL : arg.toString());
        }
        return origin;
    }

    /**
     * 将字符串转成字符分段链表
     *
     * @param str    字符串
     * @param length 要切成的字符长度
     * @return 字符串链表
     */
    public static List<String> getStrList(String str, int length) {
        if (isEmpty(str)) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = str.length();
        while (start < end) {
            int last = start + length;
            if (last < end) {
                result.add(str.substring(start, last));
            } else {
                result.add(str.substring(start, end));
            }
            start += length;
        }
        return result;
    }
}
