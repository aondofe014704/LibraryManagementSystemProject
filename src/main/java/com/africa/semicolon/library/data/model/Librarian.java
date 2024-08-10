package com.africa.semicolon.library.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Library {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}
