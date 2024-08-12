package com.africa.semicolon.library.utils;

import com.africa.semicolon.library.data.model.Book;
import com.africa.semicolon.library.data.model.ReadingFocus;
import com.africa.semicolon.library.data.model.Role;
import com.africa.semicolon.library.data.model.Subscriber;
import com.africa.semicolon.library.dto.requests.AddBookRequest;
import com.africa.semicolon.library.dto.requests.LoginSubscriberRequest;
import com.africa.semicolon.library.dto.requests.RegisterSubscriberRequest;
import com.africa.semicolon.library.dto.requests.SearchBookRequest;
import com.africa.semicolon.library.dto.responses.AddBookResponse;
import com.africa.semicolon.library.dto.responses.LoginSubscriberResponse;
import com.africa.semicolon.library.dto.responses.RegisterSubscriberResponse;
import com.africa.semicolon.library.dto.responses.SearchBookResponse;

import java.time.LocalDateTime;

public class Mapper {
    public static void mapAddBookRequest (AddBookRequest addBookRequest, Book book) {
        book.setTitle(addBookRequest.getBookTitle());
        book.setAuthor(addBookRequest.getBookAuthor());
        book.setISBN(addBookRequest.getISBN());
        book.setPublicationDate(LocalDateTime.now());
    }
    public static AddBookResponse mapAddBookResponse (Book book){
        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setBookId(book.getId());
        addBookResponse.setBookTitle(book.getTitle());
        addBookResponse.setBookAuthor(book.getAuthor());
        addBookResponse.setISBN(book.getISBN());
        addBookResponse.setPublicationDate(book.getPublicationDate());
        return addBookResponse;
    }
    public static void mapSearchBookRequest(SearchBookRequest searchBookRequest, Book book) {
        searchBookRequest.setId(book.getId());
        searchBookRequest.setTitle(book.getTitle());
        searchBookRequest.setAuthor(book.getAuthor());
    }
    public static SearchBookResponse mapSearchBookResponse(Book book){
        SearchBookResponse searchBookResponse = new SearchBookResponse();
        searchBookResponse.setBookId(book.getId());
        searchBookResponse.setBookTitle(book.getTitle());
        searchBookResponse.setBookAuthor(book.getAuthor());
        searchBookResponse.setBookISBN(book.getISBN());
        return searchBookResponse;
    }
    public static void mapRegisterSubscriberRequest(RegisterSubscriberRequest request, Subscriber subscriber){
        subscriber.setUsername(request.getUsername());
        subscriber.setEmail(request.getEmail());
        subscriber.setPassword(request.getPassword());
        subscriber.setRole(Role.LIBRARIAN);
        subscriber.setReadingFocus(ReadingFocus.JAVASCRIPT);
        subscriber.setPhoneNumber(subscriber.getPhoneNumber());
    }
    public static RegisterSubscriberResponse mapRegisterSubscriberResponse(Subscriber subscriber ){
        RegisterSubscriberResponse registerSubscriberResponse = new RegisterSubscriberResponse();
        registerSubscriberResponse.setSubscriberId(subscriber.getId());
        registerSubscriberResponse.setSubscriberId(subscriber.getEmail());
        registerSubscriberResponse.setMessage(subscriber.getEmail() + "Successfully registered");
        return registerSubscriberResponse;
    }
    public static void mapLoginRequest(LoginSubscriberRequest loginSubscriberRequest){
        loginSubscriberRequest.setEmail(loginSubscriberRequest.getEmail());
        loginSubscriberRequest.setPassword(loginSubscriberRequest.getPassword());
    }
    public static LoginSubscriberResponse mapLoginResponse( Subscriber subscriber){
        LoginSubscriberResponse loginSubscriberResponse = new LoginSubscriberResponse();
        loginSubscriberResponse.setSubscriberId(subscriber.getId());
        loginSubscriberResponse.setEmail(subscriber.getEmail());
        loginSubscriberResponse.setLoggedIn(subscriber.isLoggedIn());
        loginSubscriberResponse.setMessage("Successfully logged in");
        return loginSubscriberResponse;
    }

}
