package com.example.securityv2.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String nickname;
    private final String email;
    private final String password;
    private final int indeks;
    private final String icon;
    private final String description;
}
