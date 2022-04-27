package com.example.securityv2.service;

import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Train;
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.SubjectRepository;
import com.example.securityv2.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TrainService {
    private final TrainRepository trainRepository;
    private final static String TRAIN_NOT_FOUND_MSG = "train with name %s not found";
    private final SubjectRepository subjectRepository;
    private final static String Subject_NOT_FOUND_MSG = "subject with name %s not found";

    public List<Train> getTrain() {
        log.info("Getting all train");
        return trainRepository.findAll();
    }

    public Train getTrain(String name) {
        log.info("Getting train {}",name);
        return trainRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(TRAIN_NOT_FOUND_MSG, name)));
    }

    public Train saveTrain(Train train) {
        log.info("Saving new train {}",train.getName());
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
}
