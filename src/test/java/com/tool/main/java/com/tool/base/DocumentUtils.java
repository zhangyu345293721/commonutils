package com.tool.base;


import org.dom4j.Document;

/**
 * 将xml转成字符串
 *
 * @author: zhangyu
 */
public class DocumentUtils {

    private DocumentUtils() {
    }

    /**
     * 字符串封装成文档
     *
     * @param str 将字符串变成文档
     * @return 封装成Document
     */
    public static Document stringToDocument(String str) {
        Document doc = null;
        try {
            doc = org.dom4j.DocumentHelper.parseText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * 将文档变成字符串
     *
     * @param document 输入文档
     * @return 返回字符串
     */
    public static String xmlToString(Document document) {
        String s = document.asXML();
        return s;
    }
}
