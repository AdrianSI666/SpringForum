package com.example.securityv2.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.BadgeRepository;
import com.example.securityv2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BadgeService.class})
@ExtendWith(SpringExtension.class)
class BadgeServiceTest {
    @MockBean
    private BadgeRepository badgeRepository;

    @Autowired
    private BadgeService badgeService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link BadgeService#addBadgeToUser(String, String)}
     */
    @Test
    void testAddBadgeToUser() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        Optional<Badge> ofResult1 = Optional.of(badge);
        when(this.badgeRepository.findByName((String) any())).thenReturn(ofResult1);
        this.badgeService.addBadgeToUser("jane.doe@example.org", "Badge Name");
        verify(this.userRepository).findByEmail((String) any());
        verify(this.badgeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link BadgeService#addBadgeToUser(String, String)}
     */
    @Test
    void testAddBadgeToUser2() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.badgeRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.badgeService.addBadgeToUser("jane.doe@example.org", "Badge Name"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.badgeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link BadgeService#addBadgeToUser(String, String)}
     */
    @Test
    void testAddBadgeToUser3() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        Optional<Badge> ofResult = Optional.of(badge);
        when(this.badgeRepository.findByName((String) any())).thenReturn(ofResult);
        assertThrows(UsernameNotFoundException.class,
                () -> this.badgeService.addBadgeToUser("jane.doe@example.org", "Badge Name"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link BadgeService#addBadgeToUser(String, String)}
     */
    @Test
    void testAddBadgeToUser4() {
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(this.badgeRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.badgeService.addBadgeToUser("jane.doe@example.org", "Badge Name"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.badgeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link BadgeService#getBadges()}
     */
    @Test
    void testGetBadges() {
        ArrayList<Badge> badgeList = new ArrayList<>();
        when(this.badgeRepository.findAll()).thenReturn(badgeList);
        List<Badge> actualBadges = this.badgeService.getBadges();
        assertSame(badgeList, actualBadges);
        assertTrue(actualBadges.isEmpty());
        verify(this.badgeRepository).findAll();
    }

    /**
     * Method under test: {@link BadgeService#getBadges()}
     */
    @Test
    void testGetBadges2() {
        when(this.badgeRepository.findAll()).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.badgeService.getBadges());
        verify(this.badgeRepository).findAll();
    }

    /**
     * Method under test: {@link BadgeService#getBadge(String)}
     */
    @Test
    void testGetBadge() {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        Optional<Badge> ofResult = Optional.of(badge);
        when(this.badgeRepository.findByName((String) any())).thenReturn(ofResult);
        assertSame(badge, this.badgeService.getBadge("Name"));
        verify(this.badgeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link BadgeService#getBadge(String)}
     */
    @Test
    void testGetBadge2() {
        when(this.badgeRepository.findByName((String) any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> this.badgeService.getBadge("Name"));
        verify(this.badgeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link BadgeService#getBadge(String)}
     */
    @Test
    void testGetBadge3() {
        when(this.badgeRepository.findByName((String) any())).thenThrow(new NotFoundException("An error occurred"));
        assertThrows(NotFoundException.class, () -> this.badgeService.getBadge("Name"));
        verify(this.badgeRepository).findByName((String) any());
    }

    /**
     * Method under test: {@link BadgeService#saveBadge(Badge)}
     */
    @Test
    void testSaveBadge() {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeRepository.save((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        assertSame(badge, this.badgeService.saveBadge(badge1));
        verify(this.badgeRepository).save((Badge) any());
    }

    /**
     * Method under test: {@link BadgeService#saveBadge(Badge)}
     */
    @Test
    void testSaveBadge2() {
        when(this.badgeRepository.save((Badge) any())).thenThrow(new NotFoundException("An error occurred"));

        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        assertThrows(NotFoundException.class, () -> this.badgeService.saveBadge(badge));
        verify(this.badgeRepository).save((Badge) any());
    }

    /**
     * Method under test: {@link BadgeService#updateBadge(Badge)}
     */
    @Test
    void testUpdateBadge() {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeRepository.save((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        assertSame(badge, this.badgeService.updateBadge(badge1));
        verify(this.badgeRepository).save((Badge) any());
    }

    /**
     * Method under test: {@link BadgeService#updateBadge(Badge)}
     */
    @Test
    void testUpdateBadge2() {
        when(this.badgeRepository.save((Badge) any())).thenThrow(new NotFoundException("An error occurred"));

        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        assertThrows(NotFoundException.class, () -> this.badgeService.updateBadge(badge));
        verify(this.badgeRepository).save((Badge) any());
    }

    /**
     * Method under test: {@link BadgeService#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge() {
        doNothing().when(this.badgeRepository).deleteById((Long) any());
        this.badgeService.deleteBadge(123L);
        verify(this.badgeRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link BadgeService#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge2() {
        doThrow(new NotFoundException("An error occurred")).when(this.badgeRepository).deleteById((Long) any());
        assertThrows(NotFoundException.class, () -> this.badgeService.deleteBadge(123L));
        verify(this.badgeRepository).deleteById((Long) any());
    }
}

