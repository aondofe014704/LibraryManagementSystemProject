package com.africa.semicolon.library.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccess;
    private Object object;
}
