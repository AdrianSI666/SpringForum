package com.example.securityv2.controller;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.service.CommentaryService;
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
public class CommentaryController {
    private final CommentaryService commentaryService;
    @GetMapping("/comments")
    public ResponseEntity<List<Commentary>> getComments(){
        return ResponseEntity.ok().body(commentaryService.getCommentary());
    }

    @GetMapping("/comment/find/{id}")
    public ResponseEntity<Commentary> getCommentaryById(@PathVariable("id")Long id){
        return ResponseEntity.ok().body(commentaryService.getCommentary(id));
    }

    @GetMapping("/comment/findByUser")
    public ResponseEntity<List<Commentary>> getCommentaryByUser(@RequestParam(value = "user")String email){
        return ResponseEntity.ok().body(commentaryService.getCommentaryByUser(email));
    }
    @GetMapping("/comment/findByTrain")
    public ResponseEntity<List<Commentary>> getCommentaryByTrain(@RequestParam(value = "train")String name){
        return ResponseEntity.ok().body(commentaryService.getCommentaryByTrain(name));
    }

    @PostMapping("/commentary/save")
    public ResponseEntity<Commentary> saveCommentary(@RequestBody CommentaryByUserToTrain commentByUserToTrain){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/commentary/save").toUriString());
        Commentary commentary=commentaryService.saveCommentary(commentByUserToTrain.getCommentary());
        commentaryService.setUserToCommentary(commentary.getId(),commentByUserToTrain.getUserEmail());
        commentaryService.setTrianToCommentary(commentary.getId(),commentByUserToTrain.getTrainName());
        return ResponseEntity.created(uri).body(commentary);
    }

    @PutMapping("/commentary/update")
    public ResponseEntity<Commentary> updateCommentary(@RequestBody Commentary Commentary){
        return ResponseEntity.ok().body(commentaryService.updateCommentary(Commentary));
    }

    @DeleteMapping("/commentary/delete/{id}")
    public ResponseEntity<?> deleteCommentary(@PathVariable("id") Long id){
        commentaryService.deleteCommentary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/commentary/increment/{name}")
    public ResponseEntity<?> incrementCommentaryByName(@PathVariable("name")Long id){
        commentaryService.incrementRate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/commentary/decrement/{name}")
    public ResponseEntity<?> decrementCommentaryByName(@PathVariable("name")Long id){
        commentaryService.decrementRate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/commentary/attachment")
    public ResponseEntity<?> uploadImgaeToDB(@RequestParam("imageFile") ImageToCommentary file) throws IOException {
        byte[] imageArr = file.getImageFile().getBytes();
        commentaryService.setAttachmentTo(imageArr,file.getCommentId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
@Data
class ImageToCommentary{
    private MultipartFile imageFile;
    private Long commentId;
}

@Data
class CommentaryByUserToTrain{
    private Commentary commentary;
    private String trainName;
    private String userEmail;
}