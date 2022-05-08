package com.example.securityv2.repository;

import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);
    ArrayList<Subject> findByYear(Year year);
}