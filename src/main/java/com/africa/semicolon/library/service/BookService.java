package com.africa.semicolon.library.service;

import com.africa.semicolon.library.data.model.Book;
import com.africa.semicolon.library.dto.requests.AddBookRequest;
import com.africa.semicolon.library.dto.requests.SearchBookRequest;
import com.africa.semicolon.library.dto.responses.AddBookResponse;
import com.africa.semicolon.library.dto.responses.DeleteBookResponse;
import com.africa.semicolon.library.dto.responses.SearchBookResponse;

import java.util.List;

public interface BookService {

    AddBookResponse addBook(AddBookRequest addBookRequest);

    List<Book> getAllBooks();

    SearchBookResponse searchBook(SearchBookRequest searchBookRequest);

    DeleteBookResponse deleteBook(String bookId);
}
