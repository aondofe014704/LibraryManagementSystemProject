package com.africa.semicolon.library.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginSubscriberRequest {
    private String email;
    private String password;
}
