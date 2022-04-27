package com.example.securityv2.controller;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.domain.User;
import com.example.securityv2.service.BadgeService;
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
public class BadgeController {
    private final BadgeService badgeService;
    @GetMapping("/badges")
    public ResponseEntity<List<Badge>> getBadges(){
        return ResponseEntity.ok().body(badgeService.getBadges());
    }

    @GetMapping("/badge/find/{name}")
    public ResponseEntity<Badge> getBadgeByName(@PathVariable("name")String name){
        return ResponseEntity.ok().body(badgeService.getBadge(name));
    }

    @PostMapping("/badge/save")
    public ResponseEntity<Badge> saveBadge(@RequestBody Badge badge){
        URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(badgeService.saveBadge(badge));
    }

    @PutMapping("/badge/update")
    public ResponseEntity<Badge> updateBadge(@RequestBody Badge badge){
        return ResponseEntity.ok().body(badgeService.updateBadge(badge));
    }

    @DeleteMapping("/badge/delete/{id}")
    public ResponseEntity<?> deleteBadge(@PathVariable("id") Long id){
        badgeService.deleteBadge(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
