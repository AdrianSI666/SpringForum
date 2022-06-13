package com.example.securityv2.service;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.SubjectRepository;
import com.example.securityv2.repository.TrainRepository;
import com.example.securityv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TrainService {
    private final TrainRepository trainRepository;
    private final static String TRAIN_NOT_FOUND_MSG = "train with name %s not found";
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;
    private final Base64.Encoder encoder = Base64.getEncoder();
    private final Base64.Decoder decoder = Base64.getDecoder();
    private final static String Subject_NOT_FOUND_MSG = "subject with name %s not found";

    public List<Train> getTrain() {
        log.info("Getting all train");
        return trainRepository.findAll()
                .stream()
                .peek(train -> {
                    byte[] attachment=train.getAttachment();
                    if(attachment!=null){
                        if(attachment.length>0)train.setAttachment(decoder.decode(attachment));
                    }
                })
                .collect(Collectors.toList());
    }

    public Train getTrain(String name) {
        log.info("Getting train {}",name);
        Train train=trainRepository
                .findByName(name)
                .orElseThrow(()-> new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, name)));

        byte[] attachment=train.getAttachment();
        if(attachment!=null){
            if(attachment.length>0)train.setAttachment(decoder.decode(attachment));
        }
        return train;
//        return trainRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, name)));
    }
    public List<Train> getTrainsBySubject(String name){
        log.info("Getting trains by subject {}", name);
        return trainRepository.findBySubject(subjectRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(Subject_NOT_FOUND_MSG, name))))
                .stream()
                .peek(train -> {
                    byte[] attachment=train.getAttachment();
                    if(attachment!=null){
                        if(attachment.length>0)train.setAttachment(decoder.decode(attachment));
                    }
                })
                .collect(Collectors.toList());
    }

    public Train saveTrain(Train train) {
        log.info("Saving new train {}",train.getName());
        byte[] attachment=train.getAttachment();
        if(attachment!=null){
            if(attachment.length>0)train.setAttachment(decoder.decode(attachment));
        }
        return trainRepository.save(train);
    }

    public Train updateTrain(Train train){
        return trainRepository.save(train);
    }

    public void deleteTrain(Long id){
        trainRepository.deleteById(id);
    }

    public void setSubjectToTrain(String trainName, String subjectName){
        log.info("Saving subject {} to train {}",trainName,subjectName);
        Train train=trainRepository.findByName(trainName).orElseThrow(()->
                new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, trainName)));
        Subject subject=subjectRepository.findByName(subjectName).orElseThrow(()->
                new NotFoundException(String.format(Subject_NOT_FOUND_MSG, subjectName)));
        train.setSubject(subject);
    }

    public void incrementRate(String trainName){
        log.info("Incrementing rate of train {}",trainName);
        Train train=trainRepository.findByName(trainName).orElseThrow(()->
                new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, trainName)));
        train.setRate(train.getRate()+1);
    }

    public void decrementRate(String trainName){
        log.info("Decrementing rate of train {}",trainName);
        Train train=trainRepository.findByName(trainName).orElseThrow(()->
                new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, trainName)));
        train.setRate(train.getRate()-1);
    }

    public void setUserToTrain(String trainName, String userEmail) {
        log.info("Saving user {} to train {}",trainName,userEmail);
        Train train=trainRepository.findByName(trainName).orElseThrow(()->
                new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, trainName)));
        User user=userRepository.findByEmail(userEmail).orElseThrow(()->
                new NotFoundException(String.format(Subject_NOT_FOUND_MSG, userEmail)));
        train.setUser(user);
    }

    public void setAttachmentTo(byte[] attachment, Long id) {
        log.info("Saving file to coment {}",id);
        if(attachment!=null){
            Train train=trainRepository.findById(id).orElseThrow(()->
                    new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, id)));
            if(attachment.length>0)train.setAttachment(encoder.encode(attachment));
        }
    }

}
