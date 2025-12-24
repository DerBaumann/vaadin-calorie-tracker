package com.example.application.services;

import com.example.application.singletons.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final User user;

    public User get() {
        return user;
    }
}
