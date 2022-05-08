package com.example.securityv2.repository;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByName(String name);
    ArrayList<Faculty> findByInstitute(Institute institute);
}