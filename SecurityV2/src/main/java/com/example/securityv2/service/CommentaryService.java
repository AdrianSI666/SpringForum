package com.example.securityv2.service;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.CommentaryRepository;
import com.example.securityv2.repository.TrainRepository;
import com.example.securityv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CommentaryService {
    private final CommentaryRepository commentaryRepository;
    private final static String Commentary_NOT_FOUND_MSG = "Commentary with id %s not found";
    private final TrainRepository trainRepository;
    private final static String TRAIN_NOT_FOUND_MSG = "train with name %s not found";
    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    public List<Commentary> getCommentary() {
        log.info("Getting all commentaries");
        return commentaryRepository.findAll();
    }

    public Commentary getCommentary(Long id) {
        log.info("Getting commentary {}",id);
        return commentaryRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, id)));
    }

    public Commentary saveCommentary(Commentary commentary) {
        log.info("Saving new commentary {}",commentary.getId());
        return commentaryRepository.save(commentary);
    }

    public Commentary updateCommentary(Commentary commentary){
        return commentaryRepository.save(commentary);
    }

    public void deleteCommentary(Long id){
        commentaryRepository.deleteById(id);
    }

    public void setTrianToCommentary(Long commentaryId, String trainName){
        log.info("Saving train {} to commentary {}",commentaryId,trainName);
        Train train=trainRepository.findByName(trainName).orElseThrow(()->
                new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, trainName)));
        Commentary commentary=commentaryRepository.findById(commentaryId).orElseThrow(()->
                new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, commentaryId)));
        commentary.setTrain(train);
    }

    public void setUserToCommentary(Long commentaryId, String userEmail){
        log.info("Saving user {} to commentary {}",commentaryId,userEmail);
        User user=userRepository.findByEmail(userEmail).orElseThrow(()->
                new NotFoundException(String.format(USER_NOT_FOUND_MSG, userEmail)));
        Commentary commentary=commentaryRepository.findById(commentaryId).orElseThrow(()->
                new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, commentaryId)));
        commentary.setUser(user);
    }
}
