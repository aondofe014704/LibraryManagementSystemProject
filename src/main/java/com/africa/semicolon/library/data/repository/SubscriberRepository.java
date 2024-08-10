package com.africa.semicolon.library.data.repository;

import com.africa.semicolon.library.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
