package com.example.securityv2.controller;

import com.example.securityv2.domain.Commentary;
import com.example.securityv2.service.CommentaryService;
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

    @GetMapping("/comment/find/{user}")
    public ResponseEntity<List<Commentary>> getCommentaryByUser(@PathVariable("user")String email){
        return ResponseEntity.ok().body(commentaryService.getCommentaryByUser(email));
    }
    @GetMapping("/comment/find/{train}")
    public ResponseEntity<List<Commentary>> getCommentaryByTrain(@PathVariable("train")String name){
        return ResponseEntity.ok().body(commentaryService.getCommentaryByTrain(name));
    }

    @PostMapping("/commentary/save")
    public ResponseEntity<Commentary> saveCommentary(@RequestBody Commentary commentary){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/commentary/save").toUriString());
        commentaryService.saveCommentary(commentary);
        commentaryService.setUserToCommentary(commentary.getId(),commentary.getUser().getEmail());
        commentaryService.setTrianToCommentary(commentary.getId(),commentary.getTrain().getName());
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
}
