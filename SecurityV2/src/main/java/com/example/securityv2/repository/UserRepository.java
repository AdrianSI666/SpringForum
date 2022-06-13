package com.example.securityv2.repository;

import com.example.securityv2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
    
    @Query("select SUM(t.rate) from User a" +
            " join Train t on a.id=t.user.id" +
            " group by a.id having a.email=?1 ")
    Optional<Integer> getTrainsRating(String email);

    @Query("select SUM(c.rate) from User a" +
            " join Commentary c on a.id=c.user.id" +
            " group by a.id having a.email=?1 ")
    Optional<Integer> getCommentariesRating(String email);
}
