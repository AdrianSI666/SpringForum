package com.example.securityv2.controller;

import com.example.securityv2.domain.Year;
import com.example.securityv2.service.YearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class YearController {
    private final YearService yearService;
    @GetMapping("/years")
    public ResponseEntity<List<Year>> getFaculties(){
        return ResponseEntity.ok().body(yearService.getYear());
    }

    @GetMapping("/year/find/{name}")
    public ResponseEntity<Year> getYearByName(@PathVariable("name")String name){
        return ResponseEntity.ok().body(yearService.getYear(name));
    }

    @GetMapping("/year/find/{institute}")
    public ResponseEntity<List<Year>> getYearsByFaculty(@PathVariable("institute")String name){
        return ResponseEntity.ok().body(yearService.getYearsByFaculty(name));
    }

    @PostMapping("/year/save")
    public ResponseEntity<Year> saveYear(@RequestBody Year year){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/year/save").toUriString());
        yearService.saveYear(year);
        yearService.setFacultyToYear(year.getName(),year.getFaculty().getName());
        return ResponseEntity.created(uri).body(year);
    }

    @PutMapping("/year/update")
    public ResponseEntity<Year> updateYear(@RequestBody Year year){
        return ResponseEntity.ok().body(yearService.updateYear(year));
    }

    @DeleteMapping("/year/delete/{id}")
    public ResponseEntity<?> deleteYear(@PathVariable("id") Long id){
        yearService.deleteYear(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
