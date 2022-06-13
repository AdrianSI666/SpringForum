package com.example.securityv2.controller;

import com.example.securityv2.domain.Train;
import com.example.securityv2.service.TrainService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
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

    @GetMapping("/train/find")
    public ResponseEntity<List<Train>> getTrainBySubject(@RequestParam(value = "subject")String name){
        return ResponseEntity.ok().body(trainService.getTrainsBySubject(name));
    }

    @PostMapping("/train/save")
    public ResponseEntity<Train> saveTrain(@RequestBody SubjectToTrain subjectToTrain){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/Train/save").toUriString());
        Train train=trainService.saveTrain(subjectToTrain.getTrain());
        trainService.setSubjectToTrain(train.getName(),subjectToTrain.getSubjectName());
        trainService.setUserToTrain(train.getName(),subjectToTrain.getUserEmail());
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

    @GetMapping("/train/increment/{name}")
    public ResponseEntity<?> incrementTrainByName(@PathVariable("name")String name){
        trainService.incrementRate(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/train/decrement/{name}")
    public ResponseEntity<?> decrementTrainByName(@PathVariable("name")String name){
        trainService.decrementRate(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/train/attachment")
    public ResponseEntity<?> uploadImageToDB(@RequestParam("imageFile") ImageToTrain file) throws IOException {
        byte[] imageArr = file.getImageFile().getBytes();
        trainService.setAttachmentTo(imageArr,file.getTrainName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
@Data
class ImageToTrain{
    private MultipartFile imageFile;
    private Long trainName;
}

@Data
class SubjectToTrain{
    private Train train;
    private String subjectName;
    private String userEmail;
}