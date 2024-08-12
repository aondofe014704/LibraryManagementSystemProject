package com.africa.semicolon.library.exception;

public class SubscriberEmailExistsException extends RuntimeException {
    public SubscriberEmailExistsException(String response) {
        super(response);
    }
}
