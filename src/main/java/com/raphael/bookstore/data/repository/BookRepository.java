package com.raphael.bookstore.data.repository;

import com.raphael.bookstore.data.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByISBN(String ISBN);
}
