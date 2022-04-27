package com.example.securityv2.service;

import com.example.securityv2.domain.Institute;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InstituteService {
    private final InstituteRepository instituteRepository;
    private final static String INSTITUTE_NOT_FOUND_MSG = "institute with name %s not found";

    public List<Institute> getInstitute() {
        log.info("Getting all institutes");
        return instituteRepository.findAll();
    }

    public Institute getInstitute(String name) {
        log.info("Getting institute {}",name);
        return instituteRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(INSTITUTE_NOT_FOUND_MSG, name)));
    }

    public Institute saveInstitute(Institute institute) {
        log.info("Saving new institute {}",institute.getName());
        return instituteRepository.save(institute);
    }

    public Institute updateInstitute(Institute institute){
        return instituteRepository.save(institute);
    }

    public void deleteInstitute(Long id){
        instituteRepository.deleteById(id);
    }
}
