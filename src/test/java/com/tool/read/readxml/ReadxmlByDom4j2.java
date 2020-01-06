package com.tool.read.readxml;

/**
 * 测试解析xml的文件
 *
 * @author: zhangyu
 */


import com.tool.bean.Book;
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
            List<Element> bookElementList = mapRoot.elements("book");
            for (Element bookElement : bookElementList) {
                Book book = new Book();
                String name = bookElement.element("name").getText();
                String author = bookElement.element("author").getText();
                book.setName(name);
                book.setAuthor(author);
                booksList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
}

