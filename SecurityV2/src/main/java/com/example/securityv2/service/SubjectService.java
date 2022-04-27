package com.example.securityv2.service;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.SubjectRepository;
import com.example.securityv2.repository.YearRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final static String Subject_NOT_FOUND_MSG = "subject with name %s not found";
    private final YearRepository yearRepository;
    private final static String YEAR_NOT_FOUND_MSG = "year with name %s not found";

    public List<Subject> getSubject() {
        log.info("Getting all subject");
        return subjectRepository.findAll();
    }

    public Subject getSubject(String name) {
        log.info("Getting subject {}",name);
        return subjectRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(Subject_NOT_FOUND_MSG, name)));
    }

    public Subject saveSubject(Subject subject) {
        log.info("Saving new subject {}",subject.getName());
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }

    public void setYearToSubject(String subjectName, String yearName){
        log.info("Saving year {} to subject {}",subjectName,yearName);
        Year year=yearRepository.findByName(yearName).orElseThrow(()->
                new NotFoundException(String.format(YEAR_NOT_FOUND_MSG, yearName)));
        Subject subject=subjectRepository.findByName(subjectName).orElseThrow(()->
                new NotFoundException(String.format(Subject_NOT_FOUND_MSG, subjectName)));
        subject.setYear(year);
    }
}
