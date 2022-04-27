package com.example.securityv2.service;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.BadgeRepository;
import com.example.securityv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BadgeService {
    private final UserRepository userRepository;
    private final BadgeRepository badgeRepository;
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final static String BADGE_NOT_FOUND_MSG = "badge with name %s not found";
    public void addBadgeToUser(String email, String badgeName) {
        log.info("Saving new badge {} to user {}",badgeName,email);
        User user=userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
        Badge badge=badgeRepository.findByName(badgeName).orElseThrow(()->
                new NotFoundException(String.format(BADGE_NOT_FOUND_MSG, badgeName)));
        user.getBadges().add(badge);
    }

    public List<Badge> getBadges() {
        log.info("Getting all badges");
        return badgeRepository.findAll();
    }

    public Badge getBadge(String name) {
        log.info("Getting badge {}",name);
        return badgeRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(BADGE_NOT_FOUND_MSG, name)));
    }

    public Badge saveBadge(Badge badge) {
        log.info("Saving new badge {}",badge.getName());
        return badgeRepository.save(badge);
    }

    public Badge updateBadge(Badge badge){
        return badgeRepository.save(badge);
    }

    public void deleteBadge(Long id){
        badgeRepository.deleteById(id);
    }
}
