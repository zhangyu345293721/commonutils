package com.readfile.readxml;


import org.dom4j.Document;

/**
 * @program: utilsdemo
 * @description: 将xml转成字符串
 * @author: zhangyu
 * @create: 2019-05-23 17:14
 */
public class XmlToString {

    public static String xmlToString(Document document) {
        String s = document.asXML();
        return s;
    }
}
