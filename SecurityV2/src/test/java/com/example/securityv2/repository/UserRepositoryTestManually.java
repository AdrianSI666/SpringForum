package com.example.securityv2.repository;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class UserRepositoryTestManually {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void itShouldFindByEmail() {
        //given
        String email="adrian@test.pl";
        User user =new User(19413,"adrianT","adrianT",null,"adrian test",email,new ArrayList<Role>(),new ArrayList<Badge>());
        underTest.save(user);
        //when
        User user1=underTest.findByEmail(email).orElseThrow(()->new NotFoundException("User not found"));
        //then
        assertThat(user1).isEqualTo(user);
    }

    //Nie wiem czy jest zbytnio sens testować odwrotności metody, ponieważ są one zabezpieczone wyjątkami, które muszę jeszcze nauczyć się obsługiwać dobrze, ale
    //tak to w sumie ma sens sprawdzać czy wyrzucanie wyjątków działa, ale no jeszcze ich nie ma dobrze zrobionych
    @Test
    void itShouldNotFindByEmail() {
        //given
        String email="adrian@test.pl";
        //when
        Optional<User> user1=underTest.findByEmail(email);
        //then
        assertThat(user1).isEmpty();
    }

    @Test
    void itShouldEnableUser() {
    }
}