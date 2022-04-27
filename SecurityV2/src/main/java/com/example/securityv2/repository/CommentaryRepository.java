package com.example.securityv2.repository;

import com.example.securityv2.domain.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
}