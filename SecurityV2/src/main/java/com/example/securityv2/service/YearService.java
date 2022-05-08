package com.example.securityv2.service;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.domain.Year;
import com.example.securityv2.exception.NotFoundException;
import com.example.securityv2.repository.FacultyRepository;
import com.example.securityv2.repository.InstituteRepository;
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
public class YearService {
    private final YearRepository yearRepository;
    private final static String YEAR_NOT_FOUND_MSG = "year with name %s not found";
    private final FacultyRepository facultyRepository;
    private final static String FACULTY_NOT_FOUND_MSG = "faculty with name %s not found";

    public List<Year> getYear() {
        log.info("Getting all year");
        return yearRepository.findAll();
    }

    public Year getYear(String name) {
        log.info("Getting year {}",name);
        return yearRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(YEAR_NOT_FOUND_MSG, name)));
    }
    public List<Year> getYearsByFaculty(String name){
        log.info("Getting years by faculty {}", name);
        return yearRepository.findByFaculty(facultyRepository.findByName(name).orElseThrow(()-> new NotFoundException(String.format(FACULTY_NOT_FOUND_MSG, name))));
    }

    public Year saveYear(Year year) {
        log.info("Saving new year {}",year.getName());
        return yearRepository.save(year);
    }

    public Year updateYear(Year year){
        return yearRepository.save(year);
    }

    public void deleteYear(Long id){
        yearRepository.deleteById(id);
    }

    public void setFacultyToYear(String yearName, String facultyName){
        log.info("Saving faculty {} to year {}",yearName,facultyName);
        Year year=yearRepository.findByName(yearName).orElseThrow(()->
                new NotFoundException(String.format(YEAR_NOT_FOUND_MSG, yearName)));
        Faculty faculty=facultyRepository.findByName(facultyName).orElseThrow(()->
                new NotFoundException(String.format(FACULTY_NOT_FOUND_MSG, facultyName)));
        year.setFaculty(faculty);
    }
}
