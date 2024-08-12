package com.africa.semicolon.library.data.repository;

import com.africa.semicolon.library.data.model.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrarianRepository extends MongoRepository<Librarian, String> {
}
