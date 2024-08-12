package com.africa.semicolon.library.data.repository;

import com.africa.semicolon.library.data.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    boolean existsByTitle(String title);
    Optional<Book> findByTitle(String title);

    Book findBookById(String bookId);
}
