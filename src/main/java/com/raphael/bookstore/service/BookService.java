package com.raphael.bookstore.service;

import com.raphael.bookstore.data.model.Book;
import com.raphael.bookstore.data.model.Category;
import com.raphael.bookstore.dtos.request.AddNewBookRequest;
import com.raphael.bookstore.dtos.response.AddNewBookResponse;

import java.util.List;


public interface BookService {

    AddNewBookResponse addBook(AddNewBookRequest addNewBookRequest);

    Book getBookByISBN(String email);

    Book getBookById(String bookId);

    List<Book> getAllBooks();


    void modifyBook(String bookId, String title, String author, String publisher, Integer pages, Category category);
    void deleteBook(String bookId);

}
