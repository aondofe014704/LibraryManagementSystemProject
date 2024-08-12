package com.africa.semicolon.library.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddBookRequest {
    private String bookTitle;
    private String bookAuthor;
    private String ISBN;
    private String publicationYear;
}
