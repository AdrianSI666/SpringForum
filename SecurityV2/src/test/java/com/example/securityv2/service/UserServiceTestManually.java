package com.example.securityv2.service;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.BadRequestException;
import com.example.securityv2.registration.token.ConfirmationTokenService;
import com.example.securityv2.repository.RoleRepository;
import com.example.securityv2.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith({MockitoExtension.class})
class UserServiceTestManually {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private ConfirmationTokenService confirmationTokenService;

    private UserService underTesting;

    @BeforeEach
    void setUp() {
        underTesting=new UserService(userRepository,roleRepository,passwordEncoder,confirmationTokenService);
    }

    @Test
    void addRoleToUser() {

    }

    @Test
    void canGetUsers() {
        //When
        underTesting.getUsers();
        //Then
        verify(userRepository).findAll();
    }

    @Test
    void getUser() {
    }

    @Test
    void saveUser() {
        //given
        User user =new User(19413,
                "adrianT",
                "adrianT",
                null,
                "adrian test",
                "adrian@test.pl",
                new ArrayList<Role>(),
                new ArrayList<Badge>());
        //when
        underTesting.saveUser(user);
        //then
        ArgumentCaptor<User> argumentCaptor=ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(argumentCaptor.capture());
        User caputedUser=argumentCaptor.getValue();
        assertThat(caputedUser).isEqualTo(user);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        //given
        User user =new User(19413,
                "adrianT",
                "adrianT",
                null,
                "adrian test",
                "adrian@test.pl",
                new ArrayList<Role>(),
                new ArrayList<Badge>());
        Optional<User> optionalUser=userRepository.findByEmail(user.getEmail());//lub zamiast user.getEmail() można anyString()
        //Mockito.when(optionalUser).thenReturn(Optional.of(user));
        given(optionalUser).willReturn(Optional.of(user));
        //when
        //then
        assertThatThrownBy(()->underTesting.saveUser(user))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + user.getEmail() + " already taken");
        verify(userRepository,never()).save(any());
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    @Disabled
    void getUsersWithPaggination() {
    }

    @Test
    void getRoles() {
    }

    @Test
    void getRole() {
    }

    @Test
    void saveRole() {
    }

    @Test
    void updateRole() {
    }

    @Test
    void deleteRole() {
    }

    @Test
    void loadUserByUsername() {
    }

    @Test
    void signUpUser() {
    }

    @Test
    void enableUser() {
    }
}