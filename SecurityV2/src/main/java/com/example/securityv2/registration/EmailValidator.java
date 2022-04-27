package com.example.securityv2.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {

        return s.matches("[0-9]{5}@student.ans-elblag.pl");
    }
}
