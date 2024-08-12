package com.africa.semicolon.library.exception;

public class BookTitleAlreadyExistsException extends RuntimeException{
    public BookTitleAlreadyExistsException(String message) {
        super(message);
    }
}
