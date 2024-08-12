package com.africa.semicolon.library.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String response) {
        super(response);
    }
}
