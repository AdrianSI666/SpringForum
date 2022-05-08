package com.example.securityv2.controller;

import com.example.securityv2.domain.Institute;
import com.example.securityv2.service.InstituteService;
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
public class InstituteController {
    private final InstituteService instituteService;
    @GetMapping("/institutes")
    public ResponseEntity<List<Institute>> getFaculties(){
        return ResponseEntity.ok().body(instituteService.getInstitute());
    }

    @GetMapping("/institute/find/{name}")
    public ResponseEntity<Institute> getInstituteByName(@PathVariable("name")String name){
        return ResponseEntity.ok().body(instituteService.getInstitute(name));
    }

    @PostMapping("/institute/save")
    public ResponseEntity<Institute> saveInstitute(@RequestBody Institute institute){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/institute/save").toUriString());
        return ResponseEntity.created(uri).body(instituteService.saveInstitute(institute));
    }

    @PutMapping("/institute/update")
    public ResponseEntity<Institute> updateInstitute(@RequestBody Institute institute){
        return ResponseEntity.ok().body(instituteService.updateInstitute(institute));
    }

    @DeleteMapping("/institute/delete/{id}")
    public ResponseEntity<?> deleteInstitute(@PathVariable("id") Long id){
        instituteService.deleteInstitute(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
