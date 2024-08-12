package com.africa.semicolon.library.dto.requests;

import com.africa.semicolon.library.data.model.Reader;
import com.africa.semicolon.library.data.model.ReadingFocus;
import com.africa.semicolon.library.data.model.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterSubscriberRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private ReadingFocus readingFocus;
//    private Reader reader;
}
