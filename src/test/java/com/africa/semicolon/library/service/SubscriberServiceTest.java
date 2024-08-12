package com.africa.semicolon.library.service;

import com.africa.semicolon.library.data.model.ReadingFocus;
import com.africa.semicolon.library.data.model.Role;
import com.africa.semicolon.library.data.repository.SubscriberRepository;
import com.africa.semicolon.library.dto.requests.LoginSubscriberRequest;
import com.africa.semicolon.library.dto.requests.LogoutSubscriberRequest;
import com.africa.semicolon.library.dto.requests.RegisterSubscriberRequest;
import com.africa.semicolon.library.dto.responses.LoginSubscriberResponse;
import com.africa.semicolon.library.dto.responses.LogoutSubscriberResponse;
import com.africa.semicolon.library.dto.responses.RegisterSubscriberResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SubscriberServiceTest {
    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private SubscriberRepository subscriberRepository;
    @BeforeEach
    public void setUp() {
        subscriberRepository.deleteAll();
    }
    @Test
    public void testToRegisterASubcriber(){
        RegisterSubscriberResponse registerSubscriberResponse = registerNewSubscriber();
        assertThat(registerSubscriberResponse).isNotNull();
        assertThat(registerSubscriberResponse.getSubscriberId()).isNotNull();
        assertThat(subscriberService.getAllSubscribers().size()).isEqualTo(1L);

    }
    private RegisterSubscriberResponse registerNewSubscriber() {
        RegisterSubscriberRequest registerSubscriberRequest = new RegisterSubscriberRequest();
        registerSubscriberRequest.setEmail("newUser@example.com");
        registerSubscriberRequest.setPassword("testpassword");
        registerSubscriberRequest.setRole(Role.LIBRARIAN);
        registerSubscriberRequest.setReadingFocus(ReadingFocus.JAVA);
        registerSubscriberRequest.setUsername("testusername");
        return subscriberService.register(registerSubscriberRequest);
    }
    @Test
    public void testToLoginSubscriber(){
        registerNewSubscriber();
        LoginSubscriberResponse loginSubscriberResponse = newLoginSubscriberResponse();
        assertThat(loginSubscriberResponse).isNotNull();
        assertThat(loginSubscriberResponse.isLoggedIn()).isTrue();
        assertThat(loginSubscriberResponse.getMessage()).contains("Successfully");
    }

    private LoginSubscriberResponse newLoginSubscriberResponse() {
        LoginSubscriberRequest loginSubscriberRequest = new LoginSubscriberRequest();
        loginSubscriberRequest.setEmail("newUser@example.com");
        loginSubscriberRequest.setPassword("testpassword");
        return subscriberService.login(loginSubscriberRequest);
    }
    @Test
    public void testToLoginWithWrongPasswordThrowsException(){
        registerNewSubscriber();
        newLoginSubscriberResponse();
        LoginSubscriberRequest loginSubscriberRequest = new LoginSubscriberRequest();
        loginSubscriberRequest.setEmail("newUser@example.com");
        loginSubscriberRequest.setPassword("wrongpassword");
        assertThrows(InvalidPasswordException.class, ()->subscriberService.login(loginSubscriberRequest));
    }
    @Test
    public void testToLogOutASubscriber(){
        registerNewSubscriber();
        newLoginSubscriberResponse();
        LogoutSubscriberRequest logoutSubscriberRequest = new LogoutSubscriberRequest();
        logoutSubscriberRequest.setEmail("newUser@example.com");
        LogoutSubscriberResponse logoutSubscriberResponse = subscriberService.logout(logoutSubscriberRequest);
        assertThat(logoutSubscriberResponse).isNotNull();
        assertThat(logoutSubscriberResponse.getMessage()).isEqualTo("Successfully logged out");
        assertThat(logoutSubscriberResponse.isLoggedIn()).isFalse();
    }
}
