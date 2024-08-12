package com.africa.semicolon.library.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogoutSubscriberResponse {
    private String message;
    private boolean isLoggedIn;
}
