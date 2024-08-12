package com.africa.semicolon.library.data.repository;

import com.africa.semicolon.library.data.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
    boolean existsByEmail(String email);
    Subscriber findByEmail(String email);
}
