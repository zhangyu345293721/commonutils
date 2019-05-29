package com.zhang.readxml;

import org.dom4j.Document;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @program: utilsdemo
 * @description: 将字符串转成xml格式
 * @author: zhangyu
 * @create: 2019-05-23 17:07
 */
public class StringToXml {
    @Test
    public void fun() {
        String str = "<root>\r\n" +
                "　 <aa>\r\n" +
                "　　 <bb>dddd </bb>\r\n" +
                "　　 <c>dddd </c>\r\n" +
                "　 </aa>\r\n" +
                "</root> ";
        Document document = stringToDocument(str);
        String documentStr = XmlToString.xmlToString(document);
        System.out.println(documentStr);
    }

    public Document stringToDocument(String str) {
        Document doc = null;
        try {
            doc = org.dom4j.DocumentHelper.parseText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
}
