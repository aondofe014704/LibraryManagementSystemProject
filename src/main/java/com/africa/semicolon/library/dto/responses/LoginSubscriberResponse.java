package com.africa.semicolon.library.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginSubscriberResponse {
    private String subscriberId;
    private String email;
    private boolean isLoggedIn;
    private String message;
}
