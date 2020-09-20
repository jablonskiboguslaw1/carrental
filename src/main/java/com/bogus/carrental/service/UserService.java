package com.bogus.carrental.service;

import com.bogus.carrental.database.UserRepository;
import com.bogus.carrental.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository<UserEntity> userRepository;

    public UserEntity findByName(String name) {
        return userRepository.findByName(name).orElseThrow();
    }
}
