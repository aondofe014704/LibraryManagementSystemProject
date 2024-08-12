package com.africa.semicolon.library.controller;

import com.africa.semicolon.library.dto.requests.AddBookRequest;
import com.africa.semicolon.library.dto.requests.SearchBookRequest;
import com.africa.semicolon.library.dto.responses.AddBookResponse;
import com.africa.semicolon.library.dto.responses.ApiResponse;
import com.africa.semicolon.library.dto.responses.SearchBookResponse;
import com.africa.semicolon.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/api/v1/add-book")
    public ResponseEntity<?> addBook(@RequestBody AddBookRequest addBookRequest) {
        try {
            AddBookResponse addBookResponse = bookService.addBook(addBookRequest);
            return new ResponseEntity<>(new ApiResponse(true, addBookResponse), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),BAD_REQUEST);
        }
    }
    @PostMapping("/api/v1/search-book")
    public ResponseEntity<?> responseEntity (@RequestBody SearchBookRequest searchBookRequest){
        try {
            SearchBookResponse searchBookResponse = bookService.searchBook(searchBookRequest);
            return new ResponseEntity<>(new ApiResponse(true, searchBookResponse),CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
}