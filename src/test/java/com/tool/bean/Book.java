package com.tool.bean;

import lombok.Data;

/**
 * book的bean
 */
@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private int year;
    private double price;
}
