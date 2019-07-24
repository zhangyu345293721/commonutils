package com.zhang.readxml;

/**
 * @program: playback
 * @description: 测试解析xml的文件
 * @author: zhangyu
 * @create: 2019-05-23 15:12
 */


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 用DOM方式读取xml文件 测试解析xml中的内容
 *
 * @author zhangyu
 * @Date 2019.7.17
 */
public class ReadxmlByDom4j2 {
    @Test
    public void fun() {
        List<Book> bookList = getBookList("books.xml");
        for (Book b : bookList) {
            System.out.println(b.getName());
        }
    }

    public List<Book> getBookList(String mapPath) {
        List<Book> booksList = new ArrayList();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(mapPath));
            Element mapRoot = document.getRootElement();
            // System.out.println(mapRoot.getName());
            List<Element> bookElementList = mapRoot.elements("book");
            for (Element bookElement : bookElementList) {
                Book book = new Book();
                // private String name;
                // private String author;
                String name = bookElement.element("name").getText();
                String author = bookElement.element("author").getText();
                book.setName(name);
                book.setAuthor(author);
                booksList.add(book);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return booksList;
    }
}

