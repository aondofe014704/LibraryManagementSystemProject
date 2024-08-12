package com.africa.semicolon.library.service;

import com.africa.semicolon.library.data.model.Subscriber;
import com.africa.semicolon.library.data.repository.SubscriberRepository;
import com.africa.semicolon.library.dto.requests.LoginSubscriberRequest;
import com.africa.semicolon.library.dto.requests.LogoutSubscriberRequest;
import com.africa.semicolon.library.dto.requests.RegisterSubscriberRequest;
import com.africa.semicolon.library.dto.responses.LoginSubscriberResponse;
import com.africa.semicolon.library.dto.responses.LogoutSubscriberResponse;
import com.africa.semicolon.library.dto.responses.RegisterSubscriberResponse;
import com.africa.semicolon.library.exception.SubscriberEmailExistsException;
import com.africa.semicolon.library.exception.SubscriberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.africa.semicolon.library.utils.Mapper.*;

@Service
public class SubscriberServiceImplimentation implements SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Override
    public RegisterSubscriberResponse register(RegisterSubscriberRequest registerSubscriberRequest) {
        validateSubscriber(registerSubscriberRequest.getEmail());
        Subscriber subscriber = new Subscriber();
        mapRegisterSubscriberRequest(registerSubscriberRequest, subscriber);
        mapRegisterSubscriberResponse(subscriber);
        subscriberRepository.save(subscriber);
        return mapRegisterSubscriberResponse(subscriber);
    }
    private void validateSubscriber(String email){
        boolean existsByEmail = subscriberRepository.existsByEmail(email);
        if (existsByEmail) throw new SubscriberEmailExistsException("Email already exists");
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }
    private void validatePassword(Subscriber subscriber, String password) {
        if (!subscriber.getPassword().matches(password)) throw new InvalidPasswordException("Invalid Details");
    }

    @Override
    public LoginSubscriberResponse login(LoginSubscriberRequest loginSubscriberRequest) {
        Subscriber subscriber = subscriberRepository.findByEmail(loginSubscriberRequest.getEmail());
        validatePassword(subscriber, loginSubscriberRequest.getPassword());
        mapLoginResponse(subscriber);
        subscriber.setLoggedIn(true);
        subscriberRepository.save(subscriber);
        return mapLoginResponse(subscriber);
    }

    @Override
    public LogoutSubscriberResponse logout(LogoutSubscriberRequest logoutSubscriberRequest) {
        Subscriber subscriber = findByEmail(logoutSubscriberRequest.getEmail());
        subscriber.setLoggedIn(false);
        subscriberRepository.save(subscriber);
        LogoutSubscriberResponse logoutSubscriberResponse = new LogoutSubscriberResponse();
        logoutSubscriberResponse.setMessage("Successfully logged out");
        return logoutSubscriberResponse;
    }

    private Subscriber findByEmail(String email) {
        Subscriber subscriber = subscriberRepository.findByEmail(email);
        if (subscriber == null) {
            throw new SubscriberNotFoundException("Subscriber not found");
        }else return subscriber;
    }

}
