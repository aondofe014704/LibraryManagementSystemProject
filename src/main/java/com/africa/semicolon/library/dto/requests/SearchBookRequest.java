package com.africa.semicolon.library.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchBookRequest {
    private String id;
    private String title;
    private String author;
}
