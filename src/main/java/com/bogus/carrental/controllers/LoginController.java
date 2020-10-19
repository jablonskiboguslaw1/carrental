package com.bogus.carrental.controllers;

import com.bogus.carrental.security.LoginCredentials;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {

    }
}
