package com.example.securityv2.controller;

import com.example.securityv2.domain.Subject;
import com.example.securityv2.domain.Year;
import com.example.securityv2.service.SubjectService;
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
public class SubjectController {
    private final SubjectService subjectService;
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjects(){
        return ResponseEntity.ok().body(subjectService.getSubject());
    }

    @GetMapping("/subject/find/{name}")
    public ResponseEntity<Subject> getSubjectByName(@PathVariable("name")String name){
        return ResponseEntity.ok().body(subjectService.getSubject(name));
    }

    @GetMapping("/subject/find")
    public ResponseEntity<List<Subject>> getSubjectByYear(@RequestParam(value = "year")String name){
        return ResponseEntity.ok().body(subjectService.getSubjectByYear(name));
    }

    @PostMapping("/subject/save")
    public ResponseEntity<Subject> saveSubject(@RequestBody YearToSubject yearToSubject){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/subject/save").toUriString());
        Subject subject=subjectService.saveSubject(yearToSubject.getSubject());
        subjectService.setYearToSubject(subject.getName(),yearToSubject.getYearName());
        return ResponseEntity.created(uri).body(subject);
    }

    @PutMapping("/subject/update")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
        return ResponseEntity.ok().body(subjectService.updateSubject(subject));
    }

    @DeleteMapping("/subject/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id){
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

@Data
class YearToSubject{
    private Subject subject;
    private String yearName;
}
