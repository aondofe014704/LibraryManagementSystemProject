package com.africa.semicolon.library.data.repository;

import com.africa.semicolon.library.data.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {
}
