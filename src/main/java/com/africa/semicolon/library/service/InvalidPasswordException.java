package com.africa.semicolon.library.service;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String response) {
        super(response);
    }
}
