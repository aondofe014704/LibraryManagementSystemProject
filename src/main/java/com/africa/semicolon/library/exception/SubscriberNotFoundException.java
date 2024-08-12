package com.africa.semicolon.library.exception;

public class SubscriberNotFoundException extends RuntimeException{
    public SubscriberNotFoundException(String response) {
        super(response);
    }
}
