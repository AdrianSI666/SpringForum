package com.example.securityv2.controller;

import com.example.securityv2.domain.Train;
import com.example.securityv2.service.TrainService;
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
public class TrainController {
    private final TrainService trainService;
    @GetMapping("/trains")
    public ResponseEntity<List<Train>> getFaculties(){
        return ResponseEntity.ok().body(trainService.getTrain());
    }

    @GetMapping("/train/find/{name}")
    public ResponseEntity<Train> getTrainByName(@PathVariable("name")String name){
        return ResponseEntity.ok().body(trainService.getTrain(name));
    }

    @GetMapping("/train/find/{subject}")
    public ResponseEntity<List<Train>> getTrainByInstitute(@PathVariable("subject")String name){
        return ResponseEntity.ok().body(trainService.getTrainsBySubject(name));
    }

    @PostMapping("/train/save")
    public ResponseEntity<Train> saveTrain(@RequestBody Train train){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/Train/save").toUriString());
        trainService.saveTrain(train);
        trainService.setSubjectToTrain(train.getName(),train.getSubject().getName());
        return ResponseEntity.created(uri).body(train);
    }

    @PutMapping("/train/update")
    public ResponseEntity<Train> updateTrain(@RequestBody Train train){
        return ResponseEntity.ok().body(trainService.updateTrain(train));
    }

    @DeleteMapping("/train/delete/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable("id") Long id){
        trainService.deleteTrain(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
