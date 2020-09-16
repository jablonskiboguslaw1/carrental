package com.bogus.carrental.service;

import com.bogus.carrental.database.UserRepository;
import com.bogus.carrental.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository<User> userRepository;

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }
}
