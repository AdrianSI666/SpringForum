package com.example.securityv2.repository;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
    ArrayList<Commentary> findByUser(User user);
    ArrayList<Commentary> findByTrain(Train train);
}