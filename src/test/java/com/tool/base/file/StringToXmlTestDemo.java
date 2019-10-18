package com.tool.base.file;

import com.tool.base.DocumentUtils;
import org.dom4j.Document;
import org.junit.jupiter.api.Test;

/**
 * 将字符串转成xml格式
 *
 * @author: zhangyu
 */
public class StringToXmlTestDemo {
    @Test
    public void xml2DocumentTestDemo() {
        String str = "<root>\r\n" +
                "　 <aa>\r\n" +
                "　　 <bb>dddd </bb>\r\n" +
                "　　 <c>dddd </c>\r\n" +
                "　 </aa>\r\n" +
                "</root> ";
        Document document = DocumentUtils.stringToDocument(str);
        String documentStr = DocumentUtils.xmlToString(document);
        System.out.println(documentStr);
    }

}
