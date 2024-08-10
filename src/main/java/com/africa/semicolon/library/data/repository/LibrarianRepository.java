package com.africa.semicolon.library.data.repository;

import com.africa.semicolon.library.data.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Library, String> {
}
