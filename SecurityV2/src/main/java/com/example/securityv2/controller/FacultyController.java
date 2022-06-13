package com.example.securityv2.controller;

import com.example.securityv2.domain.Faculty;
import com.example.securityv2.domain.Institute;
import com.example.securityv2.service.FacultyService;
import com.example.securityv2.service.InstituteService;
import lombok.Data;
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
public class FacultyController {
    private final FacultyService facultyService;
    private final InstituteService instituteService;
    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> getFaculties(){
        return ResponseEntity.ok().body(facultyService.getFaculty());
    }

    @GetMapping("/faculty/find/{name}")
    public ResponseEntity<Faculty> getFacultyByName(@PathVariable("name")String name){
        return ResponseEntity.ok().body(facultyService.getFaculty(name));
    }
    
    @GetMapping("/faculty/find")
    public ResponseEntity<List<Faculty>> getFacultyByInstitute(@RequestParam("institute")String name){
        return ResponseEntity.ok().body(facultyService.getFacultyByInstitute(name));
    }

    @PostMapping("/faculty/save")
    public ResponseEntity<Faculty> saveFaculty(@RequestBody InstituteToFaculty instituteToFaculty){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/Faculty/save").toUriString());
        Institute institute=instituteService.getInstitute(instituteToFaculty.getInstituteName());
        Faculty faculty=facultyService.saveFaculty(instituteToFaculty.getFaculty());
        facultyService.setInstituteToFaculty(faculty.getName(),institute.getName());
        return ResponseEntity.created(uri).body(faculty);
    }

    @PutMapping("/faculty/update")
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty){
        return ResponseEntity.ok().body(facultyService.updateFaculty(faculty));
    }

    @DeleteMapping("/faculty/delete/{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable("id") Long id){
        facultyService.deleteFaculty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
@Data
class InstituteToFaculty{
    private Faculty faculty;
    private String instituteName;
}