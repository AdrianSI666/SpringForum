package com.example.securityv2.repository;

import com.example.securityv2.domain.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RoleRepositoryTestManually {
    @Autowired
    private RoleRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByName() {
        //given
        String name="Informatyk";
        Role role =new Role("Informatyk");
        underTest.save(role);
        //when
        Role roleGot=underTest.findByName(name);
        //then
        assertThat(roleGot).isEqualTo(role);
    }
}