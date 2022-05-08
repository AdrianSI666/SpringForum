package com.example.securityv2.service;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.User;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.FacultyRepository;
import com.example.securityv2.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FacultyService{
    private final FacultyRepository facultyRepository;
    private final InstituteRepository instituteRepository;
    private final static String FACULTY_NOT_FOUND_MSG = "faculty with name %s not found";
    private final static String INSTITUTE_NOT_FOUND_MSG = "institute with name %s not found";

    public List<Faculty> getFaculty() {
        log.info("Getting all faculties");
        return facultyRepository.findAll();
    }

    public Faculty getFaculty(String name) {
        log.info("Getting faculty {}",name);
        return facultyRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(FACULTY_NOT_FOUND_MSG, name)));
    }
    public List<Faculty> getFacultyByInstitute(String name){
        log.info("Getting commentary by train {}",name);
        return facultyRepository.findByInstitute(instituteRepository.findByName(name).orElseThrow(()->new NotFoundException(String.format(FACULTY_NOT_FOUND_MSG, name))));
    }

    public Faculty saveFaculty(Faculty faculty) {
        log.info("Saving new faculty {}",faculty.getName());
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public void setInstituteToFaculty(String facultyName, String instituteName){
        log.info("Saving institute {} to faculty {}",facultyName,instituteName);
        Institute institute=instituteRepository.findByName(instituteName).orElseThrow(()->
                new NotFoundException(String.format(INSTITUTE_NOT_FOUND_MSG, instituteName)));
        Faculty faculty=facultyRepository.findByName(facultyName).orElseThrow(()->
                new NotFoundException(String.format(INSTITUTE_NOT_FOUND_MSG, instituteName)));
        faculty.setInstitute(institute);
    }
}
