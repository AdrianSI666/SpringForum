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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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
    private final Base64.Encoder encoder = Base64.getEncoder();
    private final Base64.Decoder decoder = Base64.getDecoder();
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    public List<Commentary> getCommentary() {
        log.info("Getting all comments");
        return commentaryRepository
                .findAll()
                .stream()
                .peek(commentary -> {
                    byte[] attachment=commentary.getAttachment();
                    if(attachment!=null){
                        if(attachment.length>0)commentary.setAttachment(decoder.decode(attachment));
                    }
                })
                .collect(Collectors.toList());
    }

    public Commentary getCommentary(Long id) {
        log.info("Getting commentary {}",id);
        Commentary commentary=commentaryRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, id)));

        byte[] attachment=commentary.getAttachment();
        if(attachment!=null){
            if(attachment.length>0)commentary.setAttachment(decoder.decode(attachment));
        }
        return commentary;
    }
    public List<Commentary> getCommentaryByUser(String email) {
        log.info("Getting commentary by user {}",email);
        return commentaryRepository
                .findByUser(
                        userRepository
                                .findByEmail(email)
                                .orElseThrow(()->new NotFoundException(String.format(USER_NOT_FOUND_MSG, email)))
                ).stream()
                .peek(commentary -> {
                    byte[] attachment=commentary.getAttachment();
                    if(attachment!=null){
                        if(attachment.length>0)commentary.setAttachment(decoder.decode(attachment));
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Commentary> getCommentaryByTrain(String name) {
        log.info("Getting commentary by train {}",name);
        return commentaryRepository
                .findByTrain(
                        trainRepository
                                .findByName(name)
                                .orElseThrow(()->new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, name)))
                ).stream()
                .peek(commentary -> {
                    byte[] attachment=commentary.getAttachment();
                    if(attachment!=null){
                        if(attachment.length>0)commentary.setAttachment(decoder.decode(attachment));
                    }
                })
                .collect(Collectors.toList());
    }

    public Commentary saveCommentary(Commentary commentary) {
        log.info("Saving new commentary {}",commentary.getId());
        byte[] attachment=commentary.getAttachment();
        if(attachment!=null){
            if(attachment.length>0)commentary.setAttachment(decoder.decode(attachment));
        }
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
    public void incrementRate(Long commentaryId){
        log.info("Incrementing rate of comment {}",commentaryId);
        Commentary commentary=commentaryRepository.findById(commentaryId).orElseThrow(()->
                new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, commentaryId)));
        commentary.setRate(commentary.getRate()+1);
    }

    public void decrementRate(Long commentaryId){
        log.info("Decrementing rate of coment {}",commentaryId);
        Commentary commentary=commentaryRepository.findById(commentaryId).orElseThrow(()->
                new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, commentaryId)));
        commentary.setRate(commentary.getRate()-1);
    }

    public void setAttachmentTo(byte[] attachment, Long id) throws IOException {
        log.info("Saving file to coment {}",id);
        if(attachment!=null){
            Commentary commentary=commentaryRepository.findById(id).orElseThrow(()->
                    new NotFoundException(String.format(Commentary_NOT_FOUND_MSG, id)));
            if(attachment.length>0)commentary.setAttachment(encoder.encode(attachment));
        }
    }
}
