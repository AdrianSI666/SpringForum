package com.example.securityv2.registration.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ConfirmationTokenService.class})
@ExtendWith(SpringExtension.class)
class ConfirmationTokenServiceTest {
    @MockBean
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    /**
     * Method under test: {@link ConfirmationTokenService#saveConfirmationToken(ConfirmationToken)}
     */
    @Test
    void testSaveConfirmationToken() {
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
        when(this.confirmationTokenRepository.save((ConfirmationToken) any())).thenReturn(confirmationToken);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Icon");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Nickname");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());

        ConfirmationToken confirmationToken1 = new ConfirmationToken();
        confirmationToken1.setConfirmedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken1.setExpiresAt(LocalDateTime.of(1, 1, 1, 1, 1));
        confirmationToken1.setId(123L);
        confirmationToken1.setToken("ABC123");
        confirmationToken1.setUser(user1);
        this.confirmationTokenService.saveConfirmationToken(confirmationToken1);
        verify(this.confirmationTokenRepository).save((ConfirmationToken) any());
        assertTrue(confirmationToken1.isConfirmed());
        assertEquals(user, confirmationToken1.getUser());
        assertEquals("ABC123", confirmationToken1.getToken());
        assertEquals(123L, confirmationToken1.getId().longValue());
        assertEquals("01:01", confirmationToken1.getCreatedAt().toLocalTime().toString());
        assertEquals("0001-01-01", confirmationToken1.getExpiresAt().toLocalDate().toString());
    }

    /**
     * Method under test: {@link ConfirmationTokenService#getToken(String)}
     */
    @Test
    void testGetToken() {
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
        when(this.confirmationTokenRepository.findByToken((String) any())).thenReturn(ofResult);
        Optional<ConfirmationToken> actualToken = this.confirmationTokenService.getToken("ABC123");
        assertSame(ofResult, actualToken);
        assertTrue(actualToken.isPresent());
        verify(this.confirmationTokenRepository).findByToken((String) any());
    }

    /**
     * Method under test: {@link ConfirmationTokenService#getTokenByUser(User)}
     */
    @Test
    void testGetTokenByUser() {
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
        when(this.confirmationTokenRepository.findByUser((User) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setBadges(new ArrayList<>());
        user1.setDescription("The characteristics of someone or something");
        user1.setEmail("jane.doe@example.org");
        user1.setEnabled(true);
        user1.setIcon("Icon");
        user1.setId(123L);
        user1.setIndeks(1);
        user1.setLocked(true);
        user1.setNickname("Nickname");
        user1.setPassword("iloveyou");
        user1.setRole(new ArrayList<>());
        Optional<ConfirmationToken> actualTokenByUser = this.confirmationTokenService.getTokenByUser(user1);
        assertSame(ofResult, actualTokenByUser);
        assertTrue(actualTokenByUser.isPresent());
        verify(this.confirmationTokenRepository).findByUser((User) any());
    }

    /**
     * Method under test: {@link ConfirmationTokenService#setConfirmedAt(String)}
     */
    @Test
    void testSetConfirmedAt() {
        when(this.confirmationTokenRepository.updateConfirmedAt((String) any(), (java.time.LocalDateTime) any()))
                .thenReturn(1);
        assertEquals(1, this.confirmationTokenService.setConfirmedAt("ABC123"));
        verify(this.confirmationTokenRepository).updateConfirmedAt((String) any(), (java.time.LocalDateTime) any());
    }
}

