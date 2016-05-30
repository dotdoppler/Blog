package com.doppler.blog.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by doppler on 2016/5/29.
 */
public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        String password = "";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }
}
