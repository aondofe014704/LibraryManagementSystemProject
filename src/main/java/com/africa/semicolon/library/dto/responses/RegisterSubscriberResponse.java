package com.africa.semicolon.library.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterSubscriberResponse {
    private String subscriberId;
    private String message;
    private String email;
}
