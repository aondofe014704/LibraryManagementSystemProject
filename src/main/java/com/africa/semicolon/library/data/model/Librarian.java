package com.africa.semicolon.library.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Librarian {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    @DBRef
    private List<Book> listOfBooks;
}
