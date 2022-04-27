package com.example.securityv2.repository;

import com.example.securityv2.domain.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
    Optional<Institute> findByName(String name);
}