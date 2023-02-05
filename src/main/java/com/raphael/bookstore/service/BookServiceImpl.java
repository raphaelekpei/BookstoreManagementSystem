package com.raphael.bookstore.service;

import com.raphael.bookstore.data.model.Book;
import com.raphael.bookstore.data.model.Category;
import com.raphael.bookstore.data.repository.BookRepository;
import com.raphael.bookstore.dtos.request.AddNewBookRequest;
import com.raphael.bookstore.dtos.response.AddNewBookResponse;
import com.raphael.bookstore.exceptions.BookManagementException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    @Autowired
    private final BookRepository bookRepository;
    @Override
    public AddNewBookResponse addBook(AddNewBookRequest addNewBookRequest) {
        Optional<Book> optionalBook = bookRepository.findByISBN(addNewBookRequest.getISBN());
        if (optionalBook.isPresent()){
            throw new BookManagementException("book already exist");
        }
        Book book = new Book(
                addNewBookRequest.getTitle(),
                addNewBookRequest.getPages(),
                addNewBookRequest.getAuthor(),
                addNewBookRequest.getPublisher(),
                addNewBookRequest.getPrice(),
                addNewBookRequest.getCategory(),
                addNewBookRequest.getISBN()
        );
        bookRepository.save(book);
        AddNewBookResponse addNewBookResponse = new AddNewBookResponse();
        addNewBookResponse.setMessage("book has been successfully added");
        return null;
    }

    @Override
    public Book getBookByISBN(String ISBN) {
        Optional<Book> optionalBook = bookRepository.findByISBN(ISBN);
        if (optionalBook.isEmpty()){
            throw new BookManagementException("book not found");
        }
        return optionalBook.get();
    }

    @Override
    public Book getBookById(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()){
            throw new BookManagementException("book not found");
        }
        return optionalBook.get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void modifyBook(String bookId, String title, String author, String publisher, Integer pages, Category category) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()){
            throw new BookManagementException("book not found");
        }
        Book book = optionalBook.get();
        if (title != null){
            book.setTitle(title);
        }
        if (author != null){
            book.setAuthor(author);
        }
        if (publisher != null){
            book.setPublisher(publisher);
        }
        if (pages != null){
            book.setPages(pages);
        }
        if (category != null){
            book.setCategory(category);
        }
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(String bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new BookManagementException("book not found");
        }
        Book book = optionalBook.get();
        bookRepository.delete(book);
    }
}
