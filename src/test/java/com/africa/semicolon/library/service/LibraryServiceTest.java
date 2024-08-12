package com.africa.semicolon.library.service;

import com.africa.semicolon.library.dto.requests.AddBookRequest;
import com.africa.semicolon.library.dto.responses.AddBookResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RequiredArgsConstructor
class LibrarianServiceTest {
    @Autowired
    private LibrarianService librarianService;
    }