package com.example.securityv2.repository;

import com.example.securityv2.domain.Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YearRepository extends JpaRepository<Year, Long> {
    Optional<Year> findByName(String name);
}