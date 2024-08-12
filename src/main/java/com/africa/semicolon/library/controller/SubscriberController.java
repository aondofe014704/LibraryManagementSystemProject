package com.africa.semicolon.library.controller;

import com.africa.semicolon.library.dto.requests.LoginSubscriberRequest;
import com.africa.semicolon.library.dto.requests.LogoutSubscriberRequest;
import com.africa.semicolon.library.dto.requests.RegisterSubscriberRequest;
import com.africa.semicolon.library.dto.responses.ApiResponse;
import com.africa.semicolon.library.dto.responses.LoginSubscriberResponse;
import com.africa.semicolon.library.dto.responses.LogoutSubscriberResponse;
import com.africa.semicolon.library.dto.responses.RegisterSubscriberResponse;
import com.africa.semicolon.library.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.awt.image.ImageObserver.ERROR;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/subscribers")
@RequiredArgsConstructor
public class SubscriberController {
    private final SubscriberService subscriberService;
    @PostMapping("/api/v1/register-subscriber")
    public ResponseEntity<?> register (@RequestBody RegisterSubscriberRequest registerSubscriberRequest){
        try{
            RegisterSubscriberResponse registerSubscriberResponse = subscriberService.register(registerSubscriberRequest);
                return new ResponseEntity<>(new ApiResponse(true, registerSubscriberResponse), CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
         }
    }
    @PostMapping("/api/v1/login")
    public ResponseEntity<?> login(@RequestBody LoginSubscriberRequest loginSubscriberRequest){
        try{
            LoginSubscriberResponse loginSubscriberResponse = subscriberService.login(loginSubscriberRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginSubscriberResponse), OK);
            }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
    @PostMapping("/api/v1/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutSubscriberRequest logoutSubscriberRequest){
        try{
            LogoutSubscriberResponse logoutSubscriberResponse = subscriberService.logout(logoutSubscriberRequest);
            return new ResponseEntity<>(new ApiResponse(true, logoutSubscriberResponse), CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
}
