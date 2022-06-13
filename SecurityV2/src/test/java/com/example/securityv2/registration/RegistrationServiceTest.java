package com.example.securityv2.registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Role;
import com.example.securityv2.domain.User;
import com.example.securityv2.email.EmailSender;
import com.example.securityv2.registration.token.ConfirmationToken;
import com.example.securityv2.registration.token.ConfirmationTokenService;
import com.example.securityv2.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {RegistrationService.class})
@ExtendWith(SpringExtension.class)
class RegistrationServiceTest {
    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @MockBean
    private EmailSender emailSender;

    @MockBean
    private EmailValidator emailValidator;

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister() {
        when(this.userService.signUpUser((com.example.securityv2.domain.User) any())).thenReturn("Sign Up User");
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        assertEquals("Sign Up User", this.registrationService.register(new RegistrationRequest("Nickname",
                "jane.doe@example.org", "iloveyou", 1, "Icon", "The characteristics of someone or something")));
        verify(this.userService).signUpUser((com.example.securityv2.domain.User) any());
        verify(this.emailValidator).test((String) any());
        verify(this.emailSender).send((String) any(), (String) any());
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister2() {
        when(this.userService.signUpUser((com.example.securityv2.domain.User) any())).thenReturn("Sign Up User");
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doThrow(new IllegalStateException("foo")).when(this.emailSender).send((String) any(), (String) any());
        assertThrows(IllegalStateException.class,
                () -> this.registrationService.register(new RegistrationRequest("Nickname", "jane.doe@example.org", "iloveyou",
                        1, "Icon", "The characteristics of someone or something")));
        verify(this.userService).signUpUser((com.example.securityv2.domain.User) any());
        verify(this.emailValidator).test((String) any());
        verify(this.emailSender).send((String) any(), (String) any());
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister3() {
        when(this.userService.signUpUser((com.example.securityv2.domain.User) any())).thenReturn("Sign Up User");
        when(this.emailValidator.test((String) any())).thenReturn(false);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        assertThrows(IllegalStateException.class,
                () -> this.registrationService.register(new RegistrationRequest("Nickname", "jane.doe@example.org", "iloveyou",
                        1, "Icon", "The characteristics of someone or something")));
        verify(this.emailValidator).test((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegister4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.securityv2.registration.RegistrationRequest.getEmail()" because "request" is null
        //       at com.example.securityv2.registration.RegistrationService.register(RegistrationService.java:29)
        //   In order to prevent register(RegistrationRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   register(RegistrationRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.userService.signUpUser((com.example.securityv2.domain.User) any())).thenReturn("Sign Up User");
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        this.registrationService.register(null);
    }

    /**
     * Method under test: {@link RegistrationService#register(RegistrationRequest)}
     */
    @Test
    void testRegister5() {
        when(this.userService.signUpUser((com.example.securityv2.domain.User) any()))
                .thenThrow(new IllegalStateException("foo"));
        when(this.emailValidator.test((String) any())).thenReturn(true);
        assertThrows(IllegalStateException.class,
                () -> this.registrationService.register(new RegistrationRequest("Nickname", "jane.doe@example.org", "iloveyou",
                        1, "Icon", "The characteristics of someone or something")));
        verify(this.userService).signUpUser((com.example.securityv2.domain.User) any());
        verify(this.emailValidator).test((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#resend(User)}
     */
    @Test
    void testResend() {
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        doNothing().when(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        this.registrationService.resend(user);
        verify(this.emailValidator).test((String) any());
        verify(this.emailSender).send((String) any(), (String) any());
        verify(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());
    }

    /**
     * Method under test: {@link RegistrationService#resend(User)}
     */
    @Test
    void testResend2() {
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        doThrow(new IllegalStateException("foo")).when(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> this.registrationService.resend(user));
        verify(this.emailValidator).test((String) any());
        verify(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());
    }

    /**
     * Method under test: {@link RegistrationService#resend(User)}
     */
    @Test
    void testResend3() {
        when(this.emailValidator.test((String) any())).thenReturn(false);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        doNothing().when(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> this.registrationService.resend(user));
        verify(this.emailValidator).test((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#resend(User)}
     */
    @Test
    void testResend4() {
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        doNothing().when(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());
        User user = mock(User.class);
        when(user.getNickname()).thenThrow(new IllegalStateException("foo"));
        when(user.getEnabled()).thenReturn(true);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(user).setBadges((java.util.Collection<Badge>) any());
        doNothing().when(user).setDescription((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setEnabled((Boolean) any());
        doNothing().when(user).setIcon((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setIndeks(anyInt());
        doNothing().when(user).setLocked((Boolean) any());
        doNothing().when(user).setNickname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((java.util.Collection<Role>) any());
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> this.registrationService.resend(user));
        verify(this.emailValidator).test((String) any());
        verify(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());
        verify(user).getEnabled();
        verify(user, atLeast(1)).getEmail();
        verify(user).getNickname();
        verify(user).setBadges((java.util.Collection<Badge>) any());
        verify(user).setDescription((String) any());
        verify(user).setEmail((String) any());
        verify(user).setEnabled((Boolean) any());
        verify(user).setIcon((String) any());
        verify(user).setId((Long) any());
        verify(user).setIndeks(anyInt());
        verify(user).setLocked((Boolean) any());
        verify(user).setNickname((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((java.util.Collection<Role>) any());
    }

    /**
     * Method under test: {@link RegistrationService#resend(User)}
     */
    @Test
    void testResend5() {
        when(this.emailValidator.test((String) any())).thenReturn(true);
        doNothing().when(this.emailSender).send((String) any(), (String) any());
        doNothing().when(this.confirmationTokenService)
                .saveConfirmationToken((com.example.securityv2.registration.token.ConfirmationToken) any());
        User user = mock(User.class);
        when(user.getNickname()).thenThrow(new IllegalStateException("foo"));
        when(user.getEnabled()).thenReturn(false);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        doNothing().when(user).setBadges((java.util.Collection<Badge>) any());
        doNothing().when(user).setDescription((String) any());
        doNothing().when(user).setEmail((String) any());
        doNothing().when(user).setEnabled((Boolean) any());
        doNothing().when(user).setIcon((String) any());
        doNothing().when(user).setId((Long) any());
        doNothing().when(user).setIndeks(anyInt());
        doNothing().when(user).setLocked((Boolean) any());
        doNothing().when(user).setNickname((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setRole((java.util.Collection<Role>) any());
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        assertThrows(IllegalStateException.class, () -> this.registrationService.resend(user));
        verify(this.emailValidator).test((String) any());
        verify(user).getEnabled();
        verify(user).getEmail();
        verify(user).setBadges((java.util.Collection<Badge>) any());
        verify(user).setDescription((String) any());
        verify(user).setEmail((String) any());
        verify(user).setEnabled((Boolean) any());
        verify(user).setIcon((String) any());
        verify(user).setId((Long) any());
        verify(user).setIndeks(anyInt());
        verify(user).setLocked((Boolean) any());
        verify(user).setNickname((String) any());
        verify(user).setPassword((String) any());
        verify(user).setRole((java.util.Collection<Role>) any());
    }

    /**
     * Method under test: {@link RegistrationService#confirmToken(String)}
     */
    @Test
    void testConfirmToken() {
        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());

        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        confirmationToken.setUser(user);
        Optional<ConfirmationToken> ofResult = Optional.of(confirmationToken);
        when(this.confirmationTokenService.getToken((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> this.registrationService.confirmToken("ABC123"));
        verify(this.confirmationTokenService).getToken((String) any());
    }

    /**
     * Method under test: {@link RegistrationService#confirmToken(String)}
     */
    @Test
    void testConfirmToken2() {
        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        ConfirmationToken confirmationToken = mock(ConfirmationToken.class);
        when(confirmationToken.getConfirmedAt()).thenReturn(null);
        when(confirmationToken.getExpiresAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(confirmationToken).setConfirmedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setCreatedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setExpiresAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setId((Long) any());
        doNothing().when(confirmationToken).setToken((String) any());
        doNothing().when(confirmationToken).setUser((User) any());
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        confirmationToken.setUser(user);
        Optional<ConfirmationToken> ofResult = Optional.of(confirmationToken);
        when(this.confirmationTokenService.getToken((String) any())).thenReturn(ofResult);
        assertThrows(IllegalStateException.class, () -> this.registrationService.confirmToken("ABC123"));
        verify(this.confirmationTokenService).getToken((String) any());
        verify(confirmationToken).getConfirmedAt();
        verify(confirmationToken).getExpiresAt();
        verify(confirmationToken).setConfirmedAt((LocalDateTime) any());
        verify(confirmationToken).setCreatedAt((LocalDateTime) any());
        verify(confirmationToken).setExpiresAt((LocalDateTime) any());
        verify(confirmationToken).setId((Long) any());
        verify(confirmationToken).setToken((String) any());
        verify(confirmationToken).setUser((User) any());
    }

    /**
     * Method under test: {@link RegistrationService#confirmToken(String)}
     */
    @Test
    void testConfirmToken3() {
        when(this.confirmationTokenService.getToken((String) any())).thenReturn(Optional.empty());

        User user = new User();
        user.setBadges(new ArrayList<>());
        user.setDescription("The characteristics of someone or something");
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setIcon("Icon");
        user.setId(123L);
        user.setIndeks(1);
        user.setLocked(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRole(new ArrayList<>());
        ConfirmationToken confirmationToken = mock(ConfirmationToken.class);
        when(confirmationToken.getConfirmedAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(confirmationToken.getExpiresAt()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(confirmationToken).setConfirmedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setCreatedAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setExpiresAt((LocalDateTime) any());
        doNothing().when(confirmationToken).setId((Long) any());
        doNothing().when(confirmationToken).setToken((String) any());
        doNothing().when(confirmationToken).setUser((User) any());
        confirmationToken.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken.setId(123L);
        confirmationToken.setToken("ABC123");
        confirmationToken.setUser(user);
        assertThrows(IllegalStateException.class, () -> this.registrationService.confirmToken("ABC123"));
        verify(this.confirmationTokenService).getToken((String) any());
        verify(confirmationToken).setConfirmedAt((LocalDateTime) any());
        verify(confirmationToken).setCreatedAt((LocalDateTime) any());
        verify(confirmationToken).setExpiresAt((LocalDateTime) any());
        verify(confirmationToken).setId((Long) any());
        verify(confirmationToken).setToken((String) any());
        verify(confirmationToken).setUser((User) any());
    }
}

