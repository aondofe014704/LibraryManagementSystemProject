package com.africa.semicolon.library.service;

import com.africa.semicolon.library.data.model.Subscriber;
import com.africa.semicolon.library.dto.requests.LoginSubscriberRequest;
import com.africa.semicolon.library.dto.requests.LogoutSubscriberRequest;
import com.africa.semicolon.library.dto.requests.RegisterSubscriberRequest;
import com.africa.semicolon.library.dto.responses.LoginSubscriberResponse;
import com.africa.semicolon.library.dto.responses.LogoutSubscriberResponse;
import com.africa.semicolon.library.dto.responses.RegisterSubscriberResponse;

import java.util.List;

public interface SubscriberService {

    RegisterSubscriberResponse register(RegisterSubscriberRequest registerSubscriberRequest);

   List<Subscriber> getAllSubscribers();

    LoginSubscriberResponse login(LoginSubscriberRequest loginSubscriberRequest);

    LogoutSubscriberResponse logout(LogoutSubscriberRequest logoutSubscriberRequest);
}
