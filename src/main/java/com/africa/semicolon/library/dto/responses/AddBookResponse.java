package com.africa.semicolon.library.dto.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AddBookResponse {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private LocalDateTime dateAdded;
    private String ISBN;
    private boolean isAvailable;
    private LocalDateTime publicationDate = LocalDateTime.now();
}
