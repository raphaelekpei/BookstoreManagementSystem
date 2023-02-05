package com.raphael.bookstore.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String bookId;
    private String title;
    private Integer pages;
    private String author;
    private String publisher;
    private Double price;
    private Category category;
    private String ISBN;

    public Book(String title, Integer pages, String author, String publisher, Double price, Category category, String ISBN) {
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.ISBN = ISBN;
    }
}
