package com.africa.semicolon.library.exception;

public class IncorrectPasswordException  extends RuntimeException{
    public IncorrectPasswordException(String message) {
        super(message);
    }

}
