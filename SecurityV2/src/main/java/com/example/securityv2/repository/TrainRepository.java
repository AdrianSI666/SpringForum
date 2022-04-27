package com.example.securityv2.repository;

import com.example.securityv2.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Optional<Train> findByName(String name);
}