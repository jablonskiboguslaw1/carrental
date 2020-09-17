package com.bogus.carrental;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("string6"));
        System.out.println(new BCryptPasswordEncoder().encode("string1"));
        System.out.println(new BCryptPasswordEncoder().encode("string4"));
    }
}
