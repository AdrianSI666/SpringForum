package com.example.securityv2.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {
    /**
     * Method under test: {@link UserRepository#findByEmail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByEmail() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //   In order to prevent findByEmail(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findByEmail(String).
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = null;
        userRepository.findByEmail("foo");
    }

    /**
     * Method under test: {@link UserRepository#enableUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEnableUser() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
        //   In order to prevent enableUser(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   enableUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = null;
        userRepository.enableUser("foo");
    }
}

