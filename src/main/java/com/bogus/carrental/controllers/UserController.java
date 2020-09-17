package com.bogus.carrental.controllers;

import com.bogus.carrental.model.UserEntity;
import com.bogus.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
private final UserService userService;


    @GetMapping
    public UserEntity isUser(String name){
        return userService.findByName(name);

    }
}
