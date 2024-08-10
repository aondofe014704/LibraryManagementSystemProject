package com.africa.semicolon.library.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateBookRequest {
    private String id;
    private String newTitle;
    private String newContent;
}
