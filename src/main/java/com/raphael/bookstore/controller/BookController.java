package com.raphael.bookstore.controller;

import com.raphael.bookstore.data.model.Book;
import com.raphael.bookstore.data.model.Category;
import com.raphael.bookstore.dtos.request.AddNewBookRequest;
import com.raphael.bookstore.dtos.response.AddNewBookResponse;

import java.util.List;

public interface BookController {

    public AddNewBookResponse addBook(AddNewBookRequest addNewBookRequest);

    public Book getBookByISBN(String ISBN);

    public Book getBookById(String bookId);

    public List<Book> getAllBooks();

    public String updateBook(String bookId, String title, String author, String publisher, Integer pages, Category category);

    public String deleteBook(String id);


}
