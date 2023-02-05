package com.raphael.bookstore.controller;

import com.raphael.bookstore.data.model.Book;
import com.raphael.bookstore.data.model.Category;
import com.raphael.bookstore.dtos.request.AddNewBookRequest;
import com.raphael.bookstore.dtos.response.AddNewBookResponse;
import com.raphael.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/books")
@RestController
public class BookControllerImpl implements BookController{

    @Autowired
    private final BookService bookService;

    @Override
    @PostMapping("/new")
    public AddNewBookResponse addBook(AddNewBookRequest addNewBookRequest) {
        return bookService.addBook(addNewBookRequest);
    }

    @Override
    @GetMapping("/isbn")
    public Book getBookByISBN(String ISBN) {
        return bookService.getBookByISBN(ISBN);
    }

    @Override
    @GetMapping(path = "{bookId}")
    public Book getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    @Override
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    @PutMapping("{bookId}")
    public String updateBook(
            @PathVariable String bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Category category) {
        bookService.modifyBook(bookId, title, author, publisher, pages, category);
        return "successfully updated";
    }

    @Override
    @DeleteMapping("{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
        return "successfully deleted";
    }
}
