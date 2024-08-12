package com.africa.semicolon.library.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchBookResponse {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookISBN;
}
