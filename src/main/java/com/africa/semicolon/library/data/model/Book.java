package com.africa.semicolon.library.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private LocalDateTime publicationDate = LocalDateTime.now();
    private String ISBN;
    private boolean isAvailable;
    @DBRef
    private List<Book> listOfBooks;
}
